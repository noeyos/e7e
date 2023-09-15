package com.sy.soyeon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/redir")
public class RedirectController {

    @GetMapping("/test")
    public String test() {
        return "retest";
    }

    @PostMapping("/test")
    public String pTest(RedirectAttributes redirectAttributes) {
        // 한번만 쓸 일회성 메세지, Session에 담기는 부담스럽고
        // 모델에 담자니 URL을 리다이렉트해야 해서 담을 수 없을 땐
        // ? 뒤에 붙여서 보내자니, 웬지 보안이 데이털나 느낌이 짠할 때
        // 다른 사람보다 좀 더 있어보이고 싶을 때 실제로는 Session에 담는데,
        // 스프링이 알아서 담았다가 지워줌, 그래서 이름에 flash가 들어감
        // 주의 사항은 직접 HttpServletResponse를 이용하면 스프링이 중간에 끼지 못해서
        // 제대로 동작 안 함
        redirectAttributes.addFlashAttribute("oneTimeMessage", "바보");
        return "redirect:/redir/test";
    }
}
