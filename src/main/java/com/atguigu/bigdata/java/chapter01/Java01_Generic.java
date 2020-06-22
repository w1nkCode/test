package com.atguigu.bigdata.java.chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ygCode
 * @create 2020-06-01 8:53
 */
public class Java01_Generic {
    public static void main(String[] args) {
        //TODO 泛型
        //TODO 泛型方法
        List<String> list = new ArrayList<String>();
        list.add("");
        String s = list.get(0);

        //TODO类型擦除
        //TODO为了让泛型使用的更加方便，JAVA提供了特殊操作
        //<?extends User> or <? super User>
        //泛型其实在两个维度进行类型的操作
        //外部类型 : List
        //内部类型 : <String>
    }
}
