package com.cloud.ningshanshui.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="HelloController",description = "测试的相关信息接口")
public class HelloController {

    @GetMapping(value="/hello")
    @ApiOperation(value="获取所有测试",notes="获取所有返回String，无需参数", httpMethod = "Get")
    public Object hello() {
        return "Hello ningshanshui";
    }


    @GetMapping("/getOne")
    @ApiOperation(value="获取单个测试r",notes="获取单个测试，需参数", httpMethod = "Get")
    public String getOne(){
        //查出的所有部门信息
        return "Hello ningshanshui";
    }


    @GetMapping("/getOneByName")
    @ApiOperation(value="获取单个测试",notes="获取单个测试，需参数", httpMethod = "Get")
    public String getOneByName(){
        return "something";
    }

}