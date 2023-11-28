package com.ibanez.jem.jemguitar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@SpringBootApplication
public class GuitarApplication {

	public static void main(String[] args) {
		int mb = 1024 * 1024;
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
		long xmx = memoryBean.getHeapMemoryUsage().getMax() / mb;
		long xms = memoryBean.getHeapMemoryUsage().getInit() / mb;
		System.out.printf("Initial Memory (xms) : %dmb%n", xms);
		System.out.printf("Max Memory (xmx) : %dmb%n", xmx);

		SpringApplication.run(GuitarApplication.class, args);
	}

}
