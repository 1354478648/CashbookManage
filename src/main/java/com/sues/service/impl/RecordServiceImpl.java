package com.sues.service.impl;

import com.sues.dao.RecordMapper;
import com.sues.dao.UserMapper;
import com.sues.pojo.Record;
import com.sues.pojo.User;
import com.sues.service.RecordService;
import com.sues.utils.MybatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RecordServiceImpl implements RecordService {
    @Override
    public List<Record> getRecordList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
            return mapper.getRecordList();
        }
    }

    @Override
    public void deleteRecord(String ID) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
            mapper.deleteRecord(ID);
        }
    }

    @Override
    public void addRecord(String Amount, String CategoryID, String Type, String Status, String Note) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
            mapper.addRecord(Amount, CategoryID, Type, Status, Note);
        }
    }

    @Override
    public void updateRecord(String id, String Amount, String CategoryID, String Type, String Status, String Note) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
            mapper.updateRecord(id, Amount, CategoryID, Type, Status, Note);
        }
    }

    @Override
    public List<Record> getRecordListBySearch(String search) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
            return mapper.getRecordListBySearch(search);
        }
    }

    @Override
    public List<Record> getPreUpdateRecordList(String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
            return mapper.getPreUpdateRecordList(id);
        }
    }
}
