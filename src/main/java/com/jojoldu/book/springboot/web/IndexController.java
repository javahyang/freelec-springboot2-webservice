package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { // model: 서버 템플릿엔진에서 사용할 수 있는 객체 저장
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // 머스테치스타터 덕분에 앞경로(src/main/resources/templates/)와 파일확장자(.mustache) 자동으로 붙어서 실행됨
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
