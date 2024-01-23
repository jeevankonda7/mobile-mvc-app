package org.olympus.mobilemvcapp.controller;

import java.util.List;

import org.olympus.mobilemvcapp.dao.MobileDao;
import org.olympus.mobilemvcapp.dto.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MobileController {
	
	@Autowired
	private MobileDao mobileDao;
	
	@RequestMapping(value = "/create")
	public ModelAndView loadPage(String page,ModelAndView view) {
		view.setViewName("create");
		view.addObject("mobile", new Mobile());
		return view;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView loadUpdate(@RequestParam String id,ModelAndView view) {
		Mobile m = mobileDao.findMobile(Integer.parseInt(id));
		view.setViewName("update");
		view.addObject("mobile", m);
		return view;
	}
	
	@RequestMapping("/save")
	public String save(Mobile mobile, Model model) {
		mobileDao.save(mobile);
		List<Mobile> mobiles = mobileDao.fetchAllData();
		model.addAttribute("mydata", mobiles);
		return "display";
	}
	
	@RequestMapping(value="/")
	public String show(Model model) {
		List<Mobile> mobiles = mobileDao.fetchAllData();
		for(Mobile m:mobiles) {
			System.out.println(m.getBrand());
		}
		model.addAttribute("mydata", mobiles);
		return "display";
	}
	
	@RequestMapping(value = "/updating")
	public String update(@ModelAttribute Mobile m, Model model) {
		mobileDao.update(m);
		List<Mobile> mobiles = mobileDao.fetchAllData();
		model.addAttribute("mydata", mobiles);
		return "display";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam int id, Model model) {
		mobileDao.delete(id);
		List<Mobile> mobiles = mobileDao.fetchAllData();
		for(Mobile m:mobiles) {
			System.out.println(m.getBrand());
		}
		model.addAttribute("mydata", mobiles);
		return "display";
	}


}
