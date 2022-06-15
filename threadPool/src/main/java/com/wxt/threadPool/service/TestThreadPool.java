package com.wxt.threadPool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @description:
 * @author: wxt
 * @createDate: 2022-01-12 10:49
 * @version: 1.0
 */
@Slf4j
@Controller
@RequestMapping("/message")
public class TestThreadPool {

    /**
     * 如下方法会使@Async无效
     * 异步方法使用static修饰
     * 异步类没有使用@Component注解（或其他注解）导致spring无法扫描到异步类
     * 异步方法不能与被调用的异步方法在同一个类中
     * 类中需要使用@Autowired或@Resource等注解自动注入，不能自己手动new对象
     * 如果使用Springboot框必须在启动类中增加@EnableAsync注解
     */
    @Autowired
    private  ThreadPoolService threadPoolService;

    // 订单处理任务
    @GetMapping(value = "/sendMessage")
    public void orderTask() throws InterruptedException {

        this.cancelOrder(); // 取消订单
        threadPoolService.sendMessage1(); // 发短信的方法   1
        threadPoolService.sendMessage2(); // 发短信的方法  2

    }

    // 取消订单
    public void cancelOrder() throws InterruptedException {
        log.info("取消订单的方法执行------开始");
        log.info("取消订单的方法执行------结束 ");
    }
}
