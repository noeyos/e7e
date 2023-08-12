package com.sy.soyeon.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {

	@PostMapping(value = "/mFile", produces = "application/json;charset=utf-8")
	@ResponseBody // AJAX 요청에 응답
	public String getFile(MultipartFile file, MultipartHttpServletRequest msr) throws Exception {
		log.debug(file.getOriginalFilename());
		log.debug("" + file.getSize());
		log.debug(msr.getParameter("goodWords"));
		log.debug(msr.getParameter("badWords"));

		// 원하는 곳에 저장하기
		String path = "/Users/soyeonlee/Dev/test-folder/upload/" + file.getOriginalFilename();
		file.transferTo(new File(path));

		// 물리적 경로에 대응하는 웹경로를 리턴
		return "/myfiles/" + file.getOriginalFilename();
	}
}
