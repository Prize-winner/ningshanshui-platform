package com.cloud.ningshanshui.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.cloud.ningshanshui.admin"})
public class NingshanshuiAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(NingshanshuiAdminApplication.class, args);
	}

}

