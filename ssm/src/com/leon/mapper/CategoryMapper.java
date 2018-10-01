package com.leon.mapper;
 
import java.util.List;

import com.leon.pojo.Category;
 
public interface CategoryMapper {
 
      
    public int add(Category category);  
       
      
    public void delete(int id);  
       
      
    public Category get(int id);  
     
      
    public int update(Category category);   
       
      
    public List<Category> list();
    
    public List<Category> lists();
    
    public void control(String c);
    
      
    public int count();  
    
    
    
}