package io.zbc.learning.spring.source.bean;

/**
 * @author zbc
 * @description
 * @date 2021/5/21 15:49
 */
public class Woman implements People {
    @Override
    public void showSex() {
        System.out.println("I am a woman");
    }
}
