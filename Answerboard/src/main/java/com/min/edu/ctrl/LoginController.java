package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.Member_IService;

@Controller
public class LoginController {
	
	@Autowired
	private Member_IService iService;
	
	@RequestMapping(value = "/loginform.do", method = RequestMethod.GET)
	public String loginform() {
		return "Login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MemberDto dto, HttpServletResponse response, HttpSession session) throws IOException {
		MemberDto mdto = iService.loginMember(dto);
		if (mdto == null) {
			response.setContentType("text/html; charst=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못되거나 없는 정보입니다.')</script>;");
			out.flush();
			return "Login";
		}else {
			session.setAttribute("mdto", mdto);
			return "redirect:/boardList.do";
		}
	}
	
	@RequestMapping(value = "/signupform.do", method = RequestMethod.GET)
	public String signupForm() {
		return "signUp";
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public String signup(MemberDto dto, HttpServletResponse response) throws IOException {
		boolean isc = iService.signUpMember(dto);
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('잘못된 입력정보 입니다.')</script>;");
		out.flush();
		return "Login";
	}
	
	@RequestMapping(value = "/idDuplicateCheck.do", method= RequestMethod.GET)
	public String duplication() {
		return "idDuplicateCheck";
	}
	
	@RequestMapping(value = "/idChkAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String duplicateAjax(String checkId){
		boolean isc = iService.idDuplicateCheck(checkId);
		return isc?"true":"false";
	}
	
}
