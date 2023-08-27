package com.sy.soyeon.service;

import com.sy.soyeon.vo.HamhamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 명시적 표현 DAO에 해당
// @Service 어노테이션은 사용할 수 없음
// 인터페이스는 빈으로 new 해서 객체를 생성할 수 없기 때문
// @Mapper는 new로 객체를 만드는 게 아니라 클래스 자체를 만들어줌
public interface Hamham {

	// 읽기 리스트(여러 줄)
	public List<HamhamVO> listData();

	// 읽기 한줄
	public HamhamVO oneData(HamhamVO hamhamVO);

	// 입력
	public int insertData(HamhamVO hamhamVO);

	// 수정
	public int updateData(HamhamVO hamhamVO);

	// 삭제
	public int deleteData(HamhamVO hamhamVO);
}
