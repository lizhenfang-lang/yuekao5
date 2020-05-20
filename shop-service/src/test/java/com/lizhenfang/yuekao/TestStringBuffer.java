package com.lizhenfang.yuekao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStringBuffer {
   /* @Test
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("Hellow");
        stringBuffer.append(" World");
        getStr(stringBuffer);
        System.out.println("1+"+stringBuffer.toString());
        System.out.println("4+"+stringBuffer.toString());


    }*/
    /*@Test
    private static String getStr(StringBuffer sbx) {
        System.out.println("2+"+sbx.toString());
        sbx.append("Nice");
        System.out.println("3+"+sbx.toString());
        return null;
    }*/

    @Test
    public static void main(String[] args) {
        int a=12,b=13;
        System.out.println(a&b);
    }
}
