package com.tx.union.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 线程池工具类
 *
 * @author tanxin
 * @date 2019/5/9
 */
@Slf4j
public class ThreadPoolUtils<T> {
    // 核心线程数
    private static final int DEFAULT_CORE_SIZE = 5;
    // 线程池所容纳最大线程数(workQueue队列满了之后才开启)
    private static final int MAX_POOL_SIZE = 20;
    // 非核心线程闲置时间超时时长
    private static final int MAX_KEEP_ALIVE = 1;
    // 最大等待队列数
    private static final int MAX_QUEUE_SIZE = 20;
    // 线程池
    private volatile static ThreadPoolExecutor executor;

    /**
     * 拒绝策略  （发生时机MAX_POOL_SIZE 和 MAX_QUEUE_SIZE 都满了的时候）
     * AbortPolicy 抛出异常
     * DiscardPolicy  直接丢弃
     * DiscardOldestPolicy 丢弃最老的任务
     * CallerRunsPolicy 不使用线程池执行
     * 自定义
     */
    static {
        log.info("===========================开始执行创建线程池========================");
        if (executor == null) {
            log.info("===========================不存在创建========================");
            executor = new ThreadPoolExecutor(
                    DEFAULT_CORE_SIZE, // 核心线程数
                    MAX_POOL_SIZE, // 线程池所容纳最大线程数(workQueue队列满了之后才开启)
                    MAX_KEEP_ALIVE,  //  非核心线程闲置时间超时时长
                    TimeUnit.SECONDS, //unit：keepAliveTime的单位
                    new LinkedBlockingQueue<Runnable>(MAX_QUEUE_SIZE), // 等待队列，存储还未执行的任务
                    Executors.defaultThreadFactory(), //线程创建的工厂
                    new ThreadPoolExecutor.CallerRunsPolicy() //线程池拒绝策略 不使用线程池执行
            );
            log.info("===========================创建完成========================");
        }
        log.info("===========================已创建========================");
    }

    /**
     * 要确保该类只有一个实例对象，避免产生过多对象消费资源，所以采用单例模式
     */
    private ThreadPoolUtils() {
    }

    private static ThreadPoolUtils sInstance;

    public static ThreadPoolUtils getsInstance() {
        if (sInstance == null) {
            synchronized (ThreadPoolUtils.class) {
                sInstance = new ThreadPoolUtils();
            }
        }
        return sInstance;
    }

    /**
     * 开启一个无返回结果的线程
     *
     * @param r task线程
     */
    public void execute(Runnable r) {
        // 把一个任务丢到了线程池中
        executor.execute(r);
    }

    /**
     * 开启一个有返回结果的线程
     *
     * @param r task线程
     * @return
     */
    public Future<T> submit(Callable<T> r) {
        // 把一个任务丢到了线程池中
        return executor.submit(r);
    }

    /**
     * 开启一个有返回结果的线程
     *
     * @param r      task线程
     * @param result 返回结果类型
     * @return
     */
    public Future<T> submit(Runnable r, T result) {
        return executor.submit(r, result);
    }

    /**
     * 把任务移除等待队列
     *
     * @param r
     */
    public void cancel(Runnable r) {
        if (r != null) {
            executor.getQueue().remove(r);
        }
    }

}
