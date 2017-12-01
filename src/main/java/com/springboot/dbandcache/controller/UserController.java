package com.springboot.dbandcache.controller;

import com.springboot.dbandcache.model.User;
import com.springboot.dbandcache.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("user 相关 api")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("根据用户ID获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "long", required = true, value = "用户的id", defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 401, message = "权限校验不通过"),
            @ApiResponse(code = 404, message = "请求错误"),
            @ApiResponse(code = 500, message = "miss...")
    })
    @RequestMapping(value = "/getUserinfo", method = RequestMethod.GET)
    public User getUserinfo(@RequestParam("id") long id){
        return userService.getUser(id);
    }
}
