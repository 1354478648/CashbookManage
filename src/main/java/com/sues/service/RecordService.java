package com.sues.service;

import com.sues.pojo.Record;

import java.util.List;

public interface RecordService {
    //展示所有
    List<Record> getRecordList();
    //删除
    void deleteRecord(String ID);
    //添加
    void addRecord(String Amount,String CategoryID,String Type,String Status,String Note);
    //修改
    void updateRecord(String id,String Amount,String CategoryID,String Type,String Status,String Note);
    //查找
    List<Record> getRecordListBySearch(String search);
    //修改页面中原数据在表单中的显示
    List<Record> getPreUpdateRecordList(String id);
}
