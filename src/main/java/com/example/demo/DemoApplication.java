package com.example.demo;

import com.example.demo.OpenClosedPrinciple.PayType;
import com.example.demo.OpenClosedPrinciple.PaymentFactory;
import com.example.demo.OpenClosedPrinciple.PaymentInter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/testOCP")
	public String testOCP(@RequestParam(value = "type",
			defaultValue = "CASH") String type){
		PaymentInter pay =
				PaymentFactory.getPaymentByUserType(PayType.valueOf(type.toUpperCase()));
		String result=pay.pay();
		return result;
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}