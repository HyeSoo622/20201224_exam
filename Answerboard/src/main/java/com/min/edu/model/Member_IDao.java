package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.MemberDto;

public interface Member_IDao {
	
	public List<MemberDto> memberList();
	
	public boolean signUpMember(MemberDto dto);
	
	public boolean idDuplicateCheck(String id);
	
	public MemberDto loginMember(MemberDto dto);

}
