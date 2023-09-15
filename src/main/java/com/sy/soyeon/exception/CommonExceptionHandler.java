package com.sy.soyeon.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice // 일일이 컨트롤러에 등록하지 않고 예외처리 공통사용!
public class CommonExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String nullHandel(NullPointerException e) {
        return "Are you null " + e.getMessage();
    }

    /* 에러 났을 때 페이지 처리하고 싶으면
    ResponseBody 주석처리 하고 return에 jsp이름 넣어주면 됨

    @ExceptionHandler(NoHandlerFoundException.class, Model model)
    //@ResponseBody
    public String nullHandel(NoHandlerFoundException e) {
        model.addAttribute("error", e.getMeesage())
        return "myError";
    }
     */

    // 맨 마지막엔 이걸 넣어서, 기타 예외를 처리하면 됨
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandel(Exception e) {
        return "관심없는 예외들... " + e.getMessage();
    }


}
