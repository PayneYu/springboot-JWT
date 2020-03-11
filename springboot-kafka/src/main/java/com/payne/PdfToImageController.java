package com.payne;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2019-12-10 15:01
 */
@RestController
public class PdfToImageController {

        //经过测试,dpi为96,100,105,120,150,200中,105显示效果较为清晰,体积稳定,dpi越高图片体积越大
        //一般电脑显示分辨率为96
        public static final float DEFAULT_DPI=105;
        /**pdf转图片
         * @param pdfPath
         */
        @GetMapping("/pdfToImage")
        public String pdfToImage(String pdfPath){
            try{
                if(pdfPath==null||"".equals(pdfPath)||!pdfPath.endsWith(".pdf"))
                    return null;
                //图像合并使用参数
                int width = 0; // 总宽度
                int[] singleImgRGB; // 保存一张图片中的RGB数据
                int shiftHeight = 0;
                BufferedImage imageResult = null;//保存每张图片的像素值
                //利用PdfBox生成图像
                PDDocument pdDocument = PDDocument.load(new File(pdfPath));
                PDFRenderer renderer = new PDFRenderer(pdDocument);
                //循环每个页码
                for(int i=0,len=pdDocument.getNumberOfPages(); i<len; i++){
                    BufferedImage image=renderer.renderImageWithDPI(i, DEFAULT_DPI, ImageType.RGB);
                    int imageHeight=image.getHeight();
                    int imageWidth=image.getWidth();
                    if(i==0){//计算高度和偏移量
                        width=imageWidth;//使用第一张图片宽度;
                        //保存每页图片的像素值
                        imageResult= new BufferedImage(width, imageHeight*len, BufferedImage.TYPE_INT_RGB);
                    }else{
                        shiftHeight += imageHeight; // 计算偏移高度
                    }
                    singleImgRGB= image.getRGB(0, 0, width, imageHeight, null, 0, width);
                    imageResult.setRGB(0, shiftHeight, width, imageHeight, singleImgRGB, 0, width); // 写入流中
                }
                pdDocument.close();
                String outPath = pdfPath.replace(".pdf", "_"+DEFAULT_DPI+".jpg");
                File outFile = new File(outPath);
                ImageIO.write(imageResult, "jpg", outFile);// 写图片
                return outPath;
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
}
