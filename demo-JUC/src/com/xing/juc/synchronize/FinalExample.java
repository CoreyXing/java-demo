package com.xing.juc.synchronize;

/**
 * @author: Xingweicheng
 * @description: final关键字修饰引用类型
 * **当final修饰基本数据类型变量时，不能对基本数据类型变量重新赋值，因此基本数据类型变量不能被改变。
 * 而对于引用类型变量而言，它仅仅保存的是一个引用，final只保证这个引用类型变量所引用的地址不会发生改变，
 * 即一直引用这个对象，但这个对象属性是可以改变的。
 * 父类的final方法是不能够被子类重写的
 * final方法是可以被重载的
 * @date: 2022/11/30 20:19
 */
public class FinalExample {
    //在声明final实例成员变量时进行赋值
    private final static Person person = new Person(24, 170);
    public static void main(String[] args) {
        //对final引用数据类型person进行更改
        person.age = 22;
        System.out.println(person.toString());
    }
    static class Person {
        private int age;
        private int height;

        public Person(int age, int height) {
            this.age = age;
            this.height = height;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", height=" + height +
                    '}';
        }
    }
}
