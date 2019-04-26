package com.sora.poker.api;

import com.sora.poker.service.ServiceConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by yujingyi on 2017/12/14.
 */
@SpringBootApplication(
        scanBasePackages = {"com.sora.poker.api.controller"}
)
@Import({ServiceConfig.class})
@EnableSwagger2Doc
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
