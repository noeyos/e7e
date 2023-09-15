package com.sy.soyeon.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sy.soyeon.vo.TestVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.NoHandlerFoundException;

//@Controller + @ResponseBody
//@RestController
@Slf4j
@Controller
@RequestMapping(value = "/soyeon")
public class SoyeonController {
   
   @GetMapping("/test")
   public String getTest() {
      return "test";
   }

   @GetMapping("/rain/{name}")
   @ResponseBody
   public String getSuin(@PathVariable String name){
      System.out.println("체크 : " + name);
      return "zzang";
   }
   
   @PostMapping(value = "/rain", produces = "application/json;charset=utf-8")
   @ResponseBody
   public List<String> postRain(@RequestBody List<String> myList) {
      
      log.debug(""+myList);
      //return "{\"name\":\"kgb\"}"; // {name:"kgb"}
      
      /*
      List<String> myList = new ArrayList<String>();
      for(int i=0; i<10; i++) {
         myList.add("Hello"+i);
      }
      */
      
      return myList;
      
   }
   
   @PutMapping(value = "/rain", produces = "application/json;charset=utf-8")
   @ResponseBody
   public Map<String, String> putRain() {
      Map<String, String> myMap =new HashMap<String, String>();
      myMap.put("나이", "메롱");
      myMap.put("age", "19");

      return myMap;
   }
   
   
   @DeleteMapping("/rain")
   @ResponseBody
   public TestVO deleteRain(@RequestBody TestVO testVO) {
      
      log.debug(testVO.toString());
      /*
      System.out.println(myMap.get("name"));
      System.out.println(myMap.get("age"));
      System.out.println(myMap.get("alias"));
      */
      return testVO;
      
      //return "delete";
   }

   // NullPointerException 핸들링
//   @ExceptionHandler(NullPointerException.class)
//   @ResponseBody
//   public String nullHandel(NullPointerException e) {
//      return e.getMessage();
//   }
//
//   // 핸들러를 못 찾겠다
//   @ExceptionHandler(NoHandlerFoundException.class)
//   @ResponseBody
//   public String nullHandel(NoHandlerFoundException e) {
//      return e.getMessage();
//   }


   
   
   
   /*
   public void getSuin(HttpServletResponse resp) throws Exception {
      
      resp.getWriter().write("suin zzang");
      //return "Suin";
   }
   */
}