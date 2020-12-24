package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDto;

public interface Answerboard_IDao {
	
	public List<AnswerboardDto> selectDynamic(Map<String, Object> map);

	public boolean replyInsert(AnswerboardDto dto);

	public boolean replyUpdate(AnswerboardDto dto);

	public boolean modifyBoard(Map<String, Object> map);

	public boolean insertBoard(AnswerboardDto dto);

	public boolean multiDelete(String seq);

	public int multiDelete2(Map<String, Object> map);

}
