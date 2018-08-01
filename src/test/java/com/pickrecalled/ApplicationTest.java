package com.pickrecalled;

import com.pickrecalled.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ac;

    @Test
    public void testGetPersonInfo() {
        System.out.println("person info: " + person);
    }

    @Test
    public void testGetServiceName() {
        boolean b = ac.containsBean("helloService");
        System.out.println("get service name:" + b);
    }
}
