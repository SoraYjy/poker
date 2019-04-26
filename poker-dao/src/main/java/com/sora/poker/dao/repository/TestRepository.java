package com.sora.poker.dao.repository;

import com.sora.poker.dao.model.TestEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yujingyi on 2017/12/26.
 */
public interface TestRepository extends PagingAndSortingRepository<TestEntity, Integer> {

}
