package com.lizhenfang.yuekao.dao;

import com.lizhenfang.yuekao.entity.Nation;
import com.lizhenfang.yuekao.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShopDao extends JpaRepository<Shop,Integer>,
        JpaSpecificationExecutor<Shop> {

    Shop findShopById(Integer integer);
}