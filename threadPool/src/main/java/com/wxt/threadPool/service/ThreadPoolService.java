package com.wxt.threadPool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: wxt
 * @createDate: 2022-01-12 10:42
 * @version: 1.0
 */
@Service
@Slf4j
public class ThreadPoolService {

    @PostConstruct
    @Async("taskExecutor")
    public void  sendMessage1() throws InterruptedException {
        log.info("发送短信方法-----1   执行开始");
        Thread.sleep(5000);

        log.info("发送短信方法-----1   结束");
    }

    @PostConstruct
    @Async("taskExecutor")
    public void  sendMessage2() throws InterruptedException {
        log.info("发送短信方法-----2   执行开始");
        Thread.sleep(5000);

        log.info("发送短信方法-----2   结束");
    }
}
