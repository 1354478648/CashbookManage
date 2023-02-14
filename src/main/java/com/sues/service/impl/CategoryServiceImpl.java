package com.sues.service.impl;

import com.sues.dao.CategoryMapper;
import com.sues.pojo.Category;
import com.sues.service.CategoryService;
import com.sues.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getCategoryName() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getCategoryName();
        }
    }

    @Override
    public List<Category> getCategory() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getCategory();
        }
    }

    @Override
    public void addCategory(String Name, String Type, String Status) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.addCategory(Name, Type, Status);
        }
    }

    @Override
    public void deleteCategory(String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.deleteCategory(id);
        }
    }

    @Override
    public void updateCategory(String Name, String Type, String Status, String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.updateCategory(Name, Type, Status, id);
        }
    }

    @Override
    public List<Category> getCategoryListBySearch(String search) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getCategoryListBySearch(search);
        }
    }

    @Override
    public List<Category> getPreUpdateCategoryList(String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getPreUpdateCategoryList(id);
        }
    }
}
