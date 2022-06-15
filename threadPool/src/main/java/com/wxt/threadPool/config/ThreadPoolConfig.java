package com.wxt.threadPool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 线程配置类
 * @author: wxt
 * @createDate: 2022-01-12 10:14
 * @version: 1.0
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 默认情况下，在创建线程池后，线程池中的线程数为0，当有任务后，就会创建一个线程去执行任务，
     * 当线程池中的线程数达到corePoolSize后，就会把到达的任务放到缓存队列当中；
     * 当队列满了，就会继续创建线程，当线程数量大于等于maxPoolSize后，开始使用策略拒绝
     */

    /** 核心线程数*/
    private static final int corePoolSize  = 20;
    /** 最大线程数*/
    private static final int maxPoolSize  = 100;
    /** 允许线程空闲时间（单位：默认为秒）*/
    private static final int keepAliveTime  =  10;
    /** 缓冲队列大小*/
    private static final int queueCapacity = 200;
    /** 线程池前缀*/
    private static final String threadNamePrefix = "thread_test";

    @Bean("taskExecutor") //bean的名称，默认为首字母小写的方法名
    public ThreadPoolTaskExecutor  taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setThreadNamePrefix(threadNamePrefix);
        taskExecutor.setKeepAliveSeconds(keepAliveTime);

        //线程池拒绝任务的处理策略
        //CallerRunsPolicy:由调用 线程（提交任务的线程）处理改任务
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化
        taskExecutor.initialize();

        return taskExecutor;
    }
}
