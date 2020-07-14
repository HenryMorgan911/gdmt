package com.joys.gdmt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.joys.gdmt.Mapper")
public class GdmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdmtApplication.class, args);
	}

}
