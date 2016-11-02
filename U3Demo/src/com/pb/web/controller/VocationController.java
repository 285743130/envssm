package com.pb.web.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pb.domain.User;
import com.pb.domain.Vocation;
import com.pb.service.UserService;
import com.pb.service.VocationService;
@Controller
public class VocationController {
	VocationService vocationService;
	@Resource(name="vocationService")
	public void setVocationService(VocationService vocationService) {
		this.vocationService = vocationService;
	}
	
	UserService userService;

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (value != null && value.length() > 0) {
					try {
						setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
					} catch (ParseException e) {
						setValue(null);
					}
				} else {
					setValue(null);
				}
			}

			public String getAsText() {
				return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
			}
		});
	}
	@RequestMapping(value = "/leave.do", method = RequestMethod.GET)
	public String leave(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
	    List<Vocation> list = vocationService.findByUser(user);
	    model.addAttribute("list", list);
	    
		return "displayvocation";
	}
	
	@RequestMapping(value = "/toapplyvocation.do", method = RequestMethod.GET)
	public String toApplyVocation(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
	    List<User> list = userService.findByPermission(1);
	    model.addAttribute("list", list);
	    
		return "applyvocation";
	}
	@RequestMapping(value = "/applyvocation.do", method = RequestMethod.POST)
	public String applyVocation(HttpSession session,Model model,String name,Date beginDate,Date endDate,int days,String reason,Integer approverId){
		User applier = (User) session.getAttribute("user");
		Vocation vocation = new Vocation();
		vocation.setName(name);
		vocation.setBeginDate(beginDate);
		vocation.setEndDate(endDate);
		vocation.setDays(days);
		vocation.setReason(reason);
		vocation.setState(0);
		vocationService.addVocation(vocation, applier, approverId);
		
	    
		return "redirect:leave.do";
	}
	@RequestMapping(value = "/manageLeave.do", method = RequestMethod.GET)
	public String mangeLeave(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		List<Vocation> list = vocationService.findByApprover(user);
	    model.addAttribute("list", list);
		return "managevocation";
	}
	@RequestMapping(value = "/toexamine.do", method = RequestMethod.GET)
	public String toMangeLeave(Model model,Integer id){
		Vocation vocation =	vocationService.findById(id);
		
	    model.addAttribute("vocation", vocation);
		return "detailvocation";
	}
	@RequestMapping(value = "/examine.do", method = RequestMethod.GET)
	public String mangeLeave(Integer id,int state){
		vocationService.updateState(id, state);

		return "redirect:manageLeave.do";
	}

}
