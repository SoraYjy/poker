package com.sora.poker.api.controller;

import com.sora.poker.common.ApiResponseBody;
import com.sora.poker.common.vo.DemoVo;
import com.sora.poker.service.DemoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by yujingyi on 2016/9/6.
 */
@RestController
@Log4j2
public class DemoController {

    @Autowired
    DemoService demoService;

    @ApiOperation(value = "hello", notes = "hello接口文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "姓名", required = false, paramType = "query", dataType = "傻吊")})
    @RequestMapping(value = {"/hello"}, method = {GET})
    public ApiResponseBody<DemoVo> singIn(
            @RequestParam(value = "id", required = true) int id,
            @RequestParam(value = "name", defaultValue = "") String name,
            HttpServletRequest request) {

        log.info("id:" + id + " name:" + name);
        String newName = demoService.getTestName();

        DemoVo demoVo = DemoVo.builder()
                .id(id)
                .name(newName)
                .build();

        return ApiResponseBody.createSuccessBody(demoVo);
    }

}
