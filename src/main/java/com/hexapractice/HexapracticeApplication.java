package com.hexapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.hexapractice.common.constant.Constants.ROOT_PACKAGE;

@SpringBootApplication(scanBasePackages = ROOT_PACKAGE)
public class HexapracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexapracticeApplication.class, args);
	}

}
