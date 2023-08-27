package com.sy.soyeon.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sy.soyeon.vo.HamhamVO;

/*
 * 테스트는 spring 버전 또는 boot냐 아니냐 여부에 따라 어노테이션이 달라짐
 */

//Junit5 사용
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:config/spring/database-context.xml")
public class HamhamMapperTest {
	
	@Autowired
	private HamhamMapper hamhamMapper;
	
	@Test
	@DisplayName("testing")
	public void insertTest() {
		HamhamVO hamhamVO;
		
		for(int i=1; i<100; i++) {
			hamhamVO = new HamhamVO();
			hamhamVO.setTitle("title" + i);
			hamhamVO.setScont("content" + i);
			hamhamVO.setSname("name" + i);
			assertEquals(1, hamhamMapper.insertData(hamhamVO));
		}
		
	}
}
