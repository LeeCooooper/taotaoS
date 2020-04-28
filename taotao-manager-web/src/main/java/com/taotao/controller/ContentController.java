package com.taotao.controller;

import com.taotao.pojo.ZtreeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("content")
public class ContentController {
    @RequestMapping("/showContentZtree")
    public List<ZtreeResult> showContentZtree(){
        return null;
    }
}
