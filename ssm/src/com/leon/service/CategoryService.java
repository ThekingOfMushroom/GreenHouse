 package com.leon.service;

import java.util.List;

import com.leon.pojo.Category;

public interface CategoryService {

	List<Category> list();
	List<Category> lists();
	void control(String c);
}
