package com.sora.poker.service;


import com.sora.poker.common.utils.JSONUtil;
import com.sora.poker.dao.model.TestEntity;
import com.sora.poker.dao.repository.TestRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujingyi on 2016/9/7.
 */
@Service
@Log4j2
public class DemoService {

    @Autowired
    TestRepository testRepository;

    public String getTestName() {
        final TestEntity testEntity = testRepository.findById(1).orElse(null);
        log.info(JSONUtil.jsonEncode(testEntity));

        return testEntity.getName();
    }

}
