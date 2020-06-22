package com.atguigu.bigdata.java.chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ygCode
 * @create 2020-06-01 8:53
 */
public class Java02_Generic1 {
    public static void main(String[] args) {
        //TODO 泛型

        //TODO 泛型不可变

        AAA<User> aaa2 = new AAA<User>();
        //TODO泛型的上限，下限
        //TODO泛型上限，下限的使用场景

        //TODO上限一般用于对获取的数据进行限定

        //TODO下限一般用于插入数据的类型限定
    }
}
class AAA<T> {

}
class BBB {
    public void test( List<? extends User> list){

    }
}
class Parent {

}
class User extends Parent {

}
class Emp {

}
