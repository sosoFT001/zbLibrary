package cn.xgy.studing;

import  cn.xgy.studing.A;

/**
 * @author UpTop QQ:
 * @name Android-ZBLibrary-master
 * @time 2019/7/19 14:04
 * @change
 * @chang time
 * @class describe
 */

public class B extends A {
    @Override
    public A handle() {
         super.handle();
         System.out.println("B");
         return this;
    }
}
