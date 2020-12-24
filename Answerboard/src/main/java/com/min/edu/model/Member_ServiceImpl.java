package com.min.edu.model;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.MemberDto;

@Service
public class Member_ServiceImpl implements Member_IService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public Member_IDao iDao;

	@Override
	public List<MemberDto> memberList() {
		logger.info("memberList {}", new Date());
		return iDao.memberList();
	}

	@Override
	public boolean signUpMember(MemberDto dto) {
		logger.info("signUpMember", dto);
		return iDao.signUpMember(dto);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("idDuplicateCheck", id);
		return iDao.idDuplicateCheck(id);
	}

	@Override
	public MemberDto loginMember(MemberDto dto) {
		logger.info("loginMember {}", dto);
		return iDao.loginMember(dto);
	}

}
