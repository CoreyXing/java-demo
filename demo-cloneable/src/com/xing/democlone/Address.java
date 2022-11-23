package com.xing.democlone;

/**
 * @author: Xingweicheng
 * @description: TODO
 * @date: 2022/11/23 14:59
 */
public class Address implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address(String name) {
        this.name = name;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


