package com.tx.union.test;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tanxin
 * @date 2019/5/20
 */
public class TestMain {

    public static void main(String[] args) {
        A a = new A();
        a.setId(1);
        a.setNage("!");
        A b = new A();
        b.setId(2);
        b.setNage("!!");
        List<A> aList = new ArrayList<>();
        aList.add(a);
        aList.add(b);
        Map<Integer, String> map ;

        map = aList.stream().collect(Collectors.toMap(A::getId,A::getNage));
        System.out.println("1");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

class A implements Serializable {

    public A(Integer id, String nage) {
        this.id = id;
        this.nage = nage;
    }

    public A() {
    }


    private static final long serialVersionUID = 3194108405835334062L;

    private Integer id;

    private String nage;

    public Integer getId() {
        return id;
    }

    public String getNage() {
        return nage;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNage(String nage) {
        this.nage = nage;
    }
}
