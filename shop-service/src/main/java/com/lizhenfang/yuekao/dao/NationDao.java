package com.lizhenfang.yuekao.dao;

import com.lizhenfang.yuekao.entity.Nation;
import com.lizhenfang.yuekao.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface NationDao extends JpaRepository<Nation,Integer>,
        JpaSpecificationExecutor<Nation> {

    List<Nation> findByparent(int i);
}
