package com.leon.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.leon.mapper.CategoryMapper;
import com.leon.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void testAdd() {
		Category category = new Category();
		category.setHumi(1111);
		categoryMapper.add(category);
	}

	@Test
	public void testList() {
		System.out.println(categoryMapper);
		List<Category> cs=categoryMapper.list();
		for (Category c : cs) {
			System.out.println(c.getHumi());
		}
	}

}
