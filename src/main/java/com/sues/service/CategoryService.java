package com.sues.service;

import com.sues.pojo.Category;

import java.util.List;

public interface CategoryService {
    //展示分类名称（用于在添加&修改账单信息时 用户通过下拉框可以看到分类）
    List<Category> getCategoryName();

    List<Category> getCategory();

    void addCategory(String Name,String Type,String Status);

    void deleteCategory(String id);

    void updateCategory(String Name,String Type,String Status,String id);

    List<Category> getCategoryListBySearch(String search);

    List<Category> getPreUpdateCategoryList(String id);
}
