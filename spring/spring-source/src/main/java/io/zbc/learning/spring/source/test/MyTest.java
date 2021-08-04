package io.zbc.learning.spring.source.test;

import io.zbc.learning.spring.source.bean.People;
import io.zbc.learning.spring.source.bean.ShowSex;
import io.zbc.learning.spring.source.bean.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zbc
 * @description
 * @date 2021/5/14 16:13
 */
public class MyTest {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student bean = applicationContext.getBean(Student.class);
        System.out.println(bean.getUsername());
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ShowSex bean = (ShowSex) applicationContext.getBean("people");
        bean.showSex();
    }
}
