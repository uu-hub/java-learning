package io.zbc.learning.spring.source.bean;

/**
 * @author zbc
 * @description
 * @date 2021/5/21 15:51
 */
public abstract class ShowSex {
    public void showSex() {
        getPeople().showSex();
    }

    public abstract People getPeople();
}
