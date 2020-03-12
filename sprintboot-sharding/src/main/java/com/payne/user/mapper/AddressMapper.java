package com.payne.user.mapper;

import com.payne.user.model.Address;

/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2020-03-12 11:02
 */
public interface AddressMapper {
    /**
     * 保存
     */
    void save(Address address);

    /**
     * 查询
     * @param id
     * @return
     */
    Address get(Long id);
}
