package com.sy.soyeon.controller;

import com.sy.soyeon.service.Hamham;
import com.sy.soyeon.vo.HamhamVO;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class HamController {

    @Autowired
    private Hamham hamSVC;

    @GetMapping("/index")
    public String getView() {
        return "ham";
    }

    // RESTFUL 방식을 적용하면 기본 5가지
    // get(리스트, 1개), post, put, delete)
    // restful은 메소드로 구분

    // 여러개 조회
    @ResponseBody
    @GetMapping(value = "/hams", produces = "application/json;charset=utf-8")
    public List<HamhamVO> getHams() {
        return hamSVC.listData();
    }

    // 1개 조회
    @ResponseBody
    @GetMapping(value = "/ham/{title}", produces = "application/json;charset=utf-8")
    public HamhamVO getHam(@PathVariable String title) {
        HamhamVO hamhamVO = new HamhamVO();
        hamhamVO.setTitle(title);
        return hamSVC.oneData(hamhamVO);
    }

    // 1개 insert
    @ResponseBody
    @PostMapping(value = "/ham", produces = "application/json;charset=utf-8")
    public String postHams(@RequestBody HamhamVO hamhamVO) { //받아오는 데이터 json 문자열이어야 한다!!!!
        return Integer.toString(hamSVC.insertData(hamhamVO));
    }

    // 1개 수정
    @ResponseBody
    @PutMapping(value = "/ham", produces = "application/json;charset=utf-8")
    public String putHams(@RequestBody HamhamVO hamhamVO) {
        return Integer.toString(hamSVC.updateData(hamhamVO));
    }

    // 1개 삭제
    @ResponseBody
    @DeleteMapping(value = "/ham/{title}", produces = "application/json;charset=utf-8")
    public String deleteHams(@PathVariable String title) {
        HamhamVO hamhamVO = new HamhamVO();
        hamhamVO.setTitle(title);
        return Integer.toString(hamSVC.deleteData(hamhamVO));
    }
}
