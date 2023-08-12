package com.sy.soyeon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sy.soyeon.vo.HamhamVO;

@Mapper // 명시적 표현 DAO에 해당
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
