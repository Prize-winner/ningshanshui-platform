package com.cloud.ning.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: 启动器</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-26 16:38
 */

//@EnableAdminServer
@SpringBootApplication
public class NingMonitorApplication {

    public static void main(String[] args) {
        System.out.println("进入");
        SpringApplication.run(NingMonitorApplication.class,args);
        System.out.println("成功");
    }

}
