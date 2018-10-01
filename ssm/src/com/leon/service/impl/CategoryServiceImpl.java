package com.leon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leon.mapper.CategoryMapper;
import com.leon.pojo.Category;
import com.leon.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;
	
	
	public List<Category> list(){
		return categoryMapper.list();
	}


	@Override
	public List<Category> lists() {
		// TODO Auto-generated method stub
		return categoryMapper.lists();
	}


	@Override
	public void control(String c) {
		// TODO Auto-generated method stub
		categoryMapper.control(c);
	};

}
