package com.sunp.swagger.controller;

import com.sunp.swagger.bean.UserInfo;
import io.swagger.annotations.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/test")
@Api(description = "swagger 测试接口文档")
public class SwaggerController {

//    https://swagger.io/docs/specification/describing-parameters/#query-parameters

    @ApiOperation(value = "获取列表", notes = "获取列表页")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Map<String, Object> getList() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", new ArrayList<>());
        return map;
    }

    @ApiOperation(value = "分页获取列表", notes = "获取列表页")
    @RequestMapping(value = "/getListPage", method = RequestMethod.GET)
    public Map<String, Object> getListPage(
            @ApiParam(value = "页码", name = "pageNo", required = true) @RequestParam String pageNo,
            @ApiParam(value = "条数", name = "pageSize", required = true) @RequestParam String pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", new ArrayList<>());
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        return map;
    }

    /**
     * * Swagger的ApiImplicitParam的required只是显示为必填，并不是真正的必填，真正的必填要用RequestParam来限制
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @param ids
     * @return
     */
    @ApiOperation(value = "搜索分页获取列表", notes = "获取列表页")
    @RequestMapping(value = "/getListPageByKeyWords", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "pageNo", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "条数", name = "pageSize", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "关键字", name = "keyword", dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "排除这些id", name = "ids", dataType = "List", paramType = "query")
    })
    public Map<String, Object> getListPageByKeyWords(@RequestParam String pageNo,
                                                     @RequestParam String pageSize,
                                                     String keyword,
                                                     String ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", new ArrayList<>());
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("keyword", keyword);
        map.put("ids", ids);
        return map;
    }

    @ApiOperation(value = "搜索分页获取列表", notes = "获取列表页")
    @RequestMapping(value = "/getListPageByKeyWordsV2", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码", name = "pageNo", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "条数", name = "pageSize", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "用户", name = "userInfo", required = true, dataType = "UserInfo", paramType = "query"),
    })
    public Map<String, Object> getListPageByKeyWordsV2(String pageNo,
                                                       String pageSize,
                                                       @RequestBody UserInfo userInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", new ArrayList<>());
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("userInfo", userInfo);
        return map;
    }

    @ApiOperation(value = "getOne", notes = "获取某一项",response = UserInfo.class)
    @RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
    public Map<String, Object> getOne(@ApiParam(value = "数据id", name = "id", required = true) @PathVariable String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", id);
        return map;
    }
}
