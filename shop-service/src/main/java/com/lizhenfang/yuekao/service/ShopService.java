package com.lizhenfang.yuekao.service;


import com.lizhenfang.yuekao.dao.ShopDao;
import com.lizhenfang.yuekao.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopDao shopDao;

    public Page getPage(Integer current, Integer size, Shop shop){

       Pageable of= PageRequest.of(current,size);
        Specification<Shop> specification=new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> arrayList=new ArrayList();
                //模糊查询
                if (shop.getName()!=null && shop.getName()!=""){
                   Predicate predicate= criteriaBuilder.like(root.get("name"),
                            "%".concat(shop.getName()).concat("%"));
                   arrayList.add(predicate);
                }
                //区间查询
                if (shop.getPricestart()!=null && shop.getPriceend()!=null){
                    Predicate predicate=criteriaBuilder.between(root.get("price"),
                            shop.getPricestart(),shop.getPriceend());
                    arrayList.add(predicate);
                }
                return criteriaBuilder.and(arrayList.toArray(new Predicate[arrayList.size()]));
            }
        };
       return shopDao.findAll(specification,of);
    }
}
