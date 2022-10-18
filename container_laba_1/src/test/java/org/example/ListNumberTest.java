package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNumberTest {
    ListNumber<Double> list1 =new ListNumber<Double>();

    @BeforeEach
    void setUp() {
        list1.addNumber(7.0,1);
        list1.addNumber(3.0, 1);
        list1.addNumber(5.0, 2);
        list1.addNumber(1.0, 4);
    }

    @Test
    public void addNumber_NotCorrect() {
        boolean tmp=list1.addNumber(7.0, 7);
        Assert.assertEquals(tmp,false);
    }

    @Test
    void addNumber() {
        String result1=list1.print();
        String result2=" 3.0 5.0 7.0 1.0 ";
        Assert.assertEquals(result1,result2);
    }

    @Test
    public void deleteNumber_NotCorrect() {
        boolean tmp=list1.deleteNumber(7);
        Assert.assertEquals(tmp,false);
    }

    @Test
    void deleteNumber() {
            list1.deleteNumber(1);
            list1.deleteNumber(2);
            list1.deleteNumber(2);
            String result1=list1.print();
            String result2=" 5.0 ";
            Assert.assertEquals(result1,result2);
    }
    @Test
    public void getElem_NotCorrect() {
        Assert.assertEquals(list1.getElem(7),null);
    }

    @Test
    void getElem() {
        String result1="";
        result1+=list1.getElem(1);
        result1+=list1.getElem(3);
        result1+=list1.getElem(4);
        String result2="7.05.01.0";
    }
}