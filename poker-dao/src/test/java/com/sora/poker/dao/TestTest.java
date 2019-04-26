package com.sora.poker.dao;

import com.sora.poker.common.utils.JSONUtil;
import com.sora.poker.dao.model.TestEntity;
import com.sora.poker.dao.repository.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujingyi on 2017/12/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTest {

    @Autowired
    TestRepository testRepository;

    @Test
    public void testFindOne() throws Exception {
        TestEntity testEntity = testRepository.findById(1).orElse(null);
        System.out.println(JSONUtil.jsonEncode(testEntity));

    }
}
