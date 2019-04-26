package com.sora.poker.service;

import com.sora.poker.dao.DaoConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by yujingyi on 2017/12/26.
 */
@Configuration
@Import(DaoConfig.class)
@ComponentScan(basePackages = {"com.sora.poker.service"})
@EnableJpaRepositories(basePackages = {"com.sora.poker.dao.repository"})
@EntityScan(basePackages = {"com.sora.poker.dao.model"})
public class ServiceConfig {
}
