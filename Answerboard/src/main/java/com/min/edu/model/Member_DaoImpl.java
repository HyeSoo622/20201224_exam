package com.min.edu.model;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.MemberDto;

@Repository
public class Member_DaoImpl implements Member_IDao {
	
	private final String NS = "com.min.edu.model.Member_IDao.";
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<MemberDto> memberList() {
		logger.info("memberList{}", new Date());
		List<MemberDto> lists = sqlSession.selectList(NS+"memberList");
		return lists;
	}

	  @Override
	  public boolean signUpMember(MemberDto dto) {
	     logger.info("welcome signUpMember{}", dto);
	     String enPassword = passwordEncoder.encode(dto.getPw());	      dto.setPw(enPassword);
	     int n = sqlSession.insert(NS+"signUpMember", dto);
	     return n>0?true:false;
	  }

	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("idDuplicateCheck{}", id);
		int n = sqlSession.selectOne(NS+"idDuplicateCheck", id);
		return n>0?true:false;
	}

	   @Override
	   public MemberDto loginMember(MemberDto dto) {
	      logger.info("welcome loginMember{}", dto);
	      
	      System.out.println("암호화 로그인 실행 중");
	      MemberDto mDto = null;
	      
	      System.out.printf("화면에서 전달받은 요청 값: ============= %s ============= \n", dto.getPw());
	      String enPw = passwordEncoder.encode(dto.getPw());
	      System.out.printf("전달받은 값 암호화: ============= %s ============= \n", enPw);
	      
	      String dbPw = sqlSession.selectOne(NS+"selStringPw", dto.getId());
	      System.out.printf("DB에 입력되어 있는 값: ============= %s ============= \n", dto.getPw());

	      if(passwordEncoder.matches(dto.getPw(), dbPw)) {
	         System.out.println("=========== 비밀번호 일치");
	         mDto = sqlSession.selectOne(NS+"enLogin", dto);
	      }
	      return mDto;
	   
	   }

}
