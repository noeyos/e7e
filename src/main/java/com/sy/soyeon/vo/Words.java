package com.sy.soyeon.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //디버깅을 위해
public class Words {
	private String goodWords;
	private String badWords;
	private MultipartFile file;
}
