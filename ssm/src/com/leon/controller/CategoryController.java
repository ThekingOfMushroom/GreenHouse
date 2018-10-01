package com.leon.controller;


import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.greenhouse.ported.Company;
import com.leon.pojo.Category;
import com.leon.service.CategoryService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value="listCategory")
	@ResponseBody
	public JSONArray listCategory(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		System.out.println(categoryService.list());
		System.out.println("-------------------");
		ModelAndView mav = new ModelAndView();
		List<Category> cs= categoryService.list();
		
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		JSONArray arr = JSONArray.parseArray(JSON.toJSONString(cs));
		return arr;
	}
	@RequestMapping(value="lists")
	@ResponseBody
	public JSONArray listsCategory(){
		
		System.out.println("12235646");
		System.out.println(categoryService.list());
		ModelAndView mav = new ModelAndView();
		List<Category> cs= categoryService.lists();
//		for(Iterator iterator=cs.iterator();iterator.hasNext();) {
//			System.out.println(iterator);
//		}
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("lists");
		JSONArray arr = JSONArray.parseArray(JSON.toJSONString(cs));
		return arr;
	}
	
	@RequestMapping("control")
	public void control(HttpServletRequest request) {
		String s=request.getParameter("flag");
		System.out.println(s);
		categoryService.control(s);
//		Company.start(s);
		
	}
	

}
