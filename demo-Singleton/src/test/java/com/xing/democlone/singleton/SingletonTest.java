package com.xing.democlone.singleton;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * 测试单例模式
 * <p>
 * 提供测试单例结构的测试用例
 * <p>
 * 第一个验证，在同一个线程中，对 getInstance() 的多次调用结果是相同的
 * 第二个验证，在不同的线程中，对 getInstance() 的多次调用结果也是一样的
 */
public abstract class SingletonTest<S> {

    /**
     * 获取单例实例的方法
     */
//    每次调用get()方法时都会调用构造方法创建一个新对象
    private final Supplier<S> singletonInstanceMethod;

    /**
     * 创建一个测试用例
     *
     * @param singletonInstanceMethod 实例类中获取实例的方法
     */
    public SingletonTest(final Supplier<S> singletonInstanceMethod) {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }

    /**
     * 测试在同一线程中的多次调用返回结果是相同的
     */
    @Test
    public void testMultipleCallsReturnSameObjectInSameThread() {
        // 在同一线程中创建多个实例
        S instance1 = singletonInstanceMethod.get();
        S instance2 = singletonInstanceMethod.get();
        S instance3 = singletonInstanceMethod.get();

        // 分别验证是否相同
        assertSame(instance1, instance2);
        assertSame(instance2, instance3);
        assertSame(instance3, instance1);
    }

    /**
     * 测试在不同线程中的多次调用返回的结果也是相同的
     */
    @Test(timeout = 5000L)
    public void testMultipleCallsReturnSameObjectInMultipleThread() throws InterruptedException, ExecutionException {

        // 创建 5000 个任务，并在每个任务中实例化单例类
        List<Callable<S>> tasks = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            tasks.add(singletonInstanceMethod::get);
        }

        // 使用 10 个不同的线程来分别执行这 5000 个任务
        final ExecutorService pool = Executors.newFixedThreadPool(10);
        final List<Future<S>> results = pool.invokeAll(tasks);
        System.out.println(results.size());//5000

        // 预期结果
        S expectedResult = singletonInstanceMethod.get();

        // 分别验证是否是同一个对象
        for (Future<S> res : results) {
            final S result = res.get();
            assertNotNull(result);
            assertSame(expectedResult, result);
        }
    }
}

