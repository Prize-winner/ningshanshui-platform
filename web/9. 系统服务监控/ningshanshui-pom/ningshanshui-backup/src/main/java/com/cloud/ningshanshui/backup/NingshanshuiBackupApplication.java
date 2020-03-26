package com.cloud.ningshanshui.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: 启动器</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-26 14:03
 */

@SpringBootApplication(scanBasePackages={"com.cloud.ningshanshui"})
public class NingshanshuiBackupApplication {
    public static void main(String[] args) {
        SpringApplication.run(NingshanshuiBackupApplication.class, args);
    }
}
