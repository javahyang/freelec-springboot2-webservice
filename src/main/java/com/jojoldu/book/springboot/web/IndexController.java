package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index"; // 머스테치스타터 덕분에 앞경로(src/main/resources/templates/)와 파일확장자(.mustache) 자동으로 붙어서 실행됨
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
