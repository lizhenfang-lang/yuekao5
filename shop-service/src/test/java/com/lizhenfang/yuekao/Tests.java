package com.lizhenfang.yuekao;

import com.lizhenfang.yuekao.dao.NationDao;
import com.lizhenfang.yuekao.dao.ShopDao;
import com.lizhenfang.yuekao.entity.Nation;
import com.lizhenfang.yuekao.entity.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Tests {
    @Autowired
    NationDao nationDao;

    @Autowired
    ShopDao shopDao;

    @Test
    public void list(){
        System.out.println(nationDao.findAll());
    }

    @Test
    public void list2(){
        System.out.println(shopDao.findAll());
    }

    @Test
    public void insert(){
       Shop shop= new Shop();
       shop.setName("水杯");
       shop.setPrice(12);
       shop.setPrice(10);
       shop.setMiaosu("质量好");
       shopDao.save(shop);

    }

    /**
     * 0518小测试
     * @param args
     */
    @Test
    public static void main(String[] args) {
        int a=10,b=11;
        int temp_a=0,temp_b=0;
        temp_a=a++;
        temp_b=++b;

        System.out.println("a="+a);
        System.out.println("temp_a="+temp_a);
        System.out.println("b="+b);
        System.out.println("temp_b="+temp_b);
    }



}
