package com.pb.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import com.pb.domain.Email;
import com.pb.domain.User;
import com.pb.service.EmailService;
import com.pb.service.UserService;
@Controller
public class EmailController {
	EmailService emailService;
	@Resource(name="emailService")
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	UserService userService;

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value = "/emailWriter.do", method = RequestMethod.GET)
	public String findByReciverId(Integer id,Model model){
		List<User> list = userService.findAll();
		model.addAttribute("list", list);
		return "emailwriter";
		
	}
	@RequestMapping(value = "/mailReceive.do", method = RequestMethod.GET)
	public String mailReceive(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		List<Email> list = emailService.findByUser(user, 0);
		model.addAttribute("list", list);
		return "displayEmail";
		
	}
	@RequestMapping(value = "/junkMail.do", method = RequestMethod.GET)
	public String junkMail(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		List<Email> list = emailService.findByUser(user, 1);
		model.addAttribute("list", list);
		return "junkEmail";
		
	}
	@RequestMapping(value = "/detailEmail.do", method = RequestMethod.GET)
	public String detailEmail(Integer id,Model model){
		Email email = emailService.findById(id);
		email.setIsRead(1);
		emailService.updateIsRead(id);
		model.addAttribute("email", email);
		return "detailEmail";
		
	}
	@RequestMapping(value = "/updateIsDelete.do", method = RequestMethod.GET)
	public String updateIsDelete(Integer id){
		emailService.updateIsDelete(id,1);
		return "redirect:mailReceive.do";
	}
	@RequestMapping(value = "/deleteEmail.do", method = RequestMethod.GET)
	public String deleteEmail(Integer id){
		emailService.deleteEmail(id);
		return "redirect:junkMail.do";
	}
	@RequestMapping(value = "/emailRestore.do", method = RequestMethod.GET)
	public String emailRestore(Integer id){
		emailService.updateIsDelete(id,0);
		return "redirect:junkMail.do";
	}
	@RequestMapping(value = "/downfile.do", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(HttpServletRequest request, Integer id) throws IOException {
		String downloadFileName = emailService.findById(id).getAttachment();
		String path = request.getSession().getServletContext().getRealPath("/upload/" + downloadFileName);
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		String fileName = new String(downloadFileName.getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);// HttpStatus.CREATED
	}

	@RequestMapping(value = "/emailwriter.do", method = RequestMethod.POST)
	public String addStandard(Integer reciverId,String title,String context,MultipartFile upfile, HttpServletRequest request,HttpSession session) {
		User sender = (User) session.getAttribute("user");
		User reciver = userService.findById(reciverId);
		if (upfile != null && !("".equals(upfile))) {
			// 创建你要保存的文件的路径
			String path = request.getSession().getServletContext().getRealPath("/upload");
			// 获取该文件的文件名
			String fileName = upfile.getOriginalFilename();
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				
				Email email = new Email();
				email.setTitle(title);
				email.setSenderDate(new Date());
				email.setSender(sender);
				email.setReciver(reciver);
				email.setIsRead(0);
				email.setIsDelete(0);
				email.setContext(context);
				email.setAttachment(fileName);
				upfile.transferTo(targetFile);
				emailService.saveEmail(email, sender, reciverId);;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		List<Email> list = emailService.findByUser(sender, 0);
		request.setAttribute("list", list);
		return "displayEmail";
	}
}
