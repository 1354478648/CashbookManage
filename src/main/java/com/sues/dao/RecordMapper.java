package com.sues.dao;

import com.sues.pojo.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecordMapper {
    //@Results注解用于对应数据库字段名和实体类属性名，column是数据库字段名，property是实体类属性名
    @Results({
            @Result(column = "ID", property = "ID"),
            @Result(column = "OwnerID",property = "OwnerID"),
            @Result(column = "AccountID",property = "AccountID"),
            @Result(column = "CategoryID", property = "CategoryID"),
            @Result(column = "Amount", property = "Amount"),
            @Result(column = "Type", property = "Type"),
            @Result(column = "Note", property = "Note"),
            @Result(column = "Status", property = "Status"),
            @Result(column = "CreatedAt", property = "CreatedAt"),
            @Result(column = "UpdatedAt", property = "UpdatedAt"),
    })
    //账单列表信息的展示
    @Select("select ID,Amount,CategoryID,Type,Status,CreatedAt,UpdatedAt,Note from record")
    List<Record> getRecordList();
    //删除
    @Delete("delete from record where ID = #{ID}")
    void deleteRecord(String ID);
    //添加
    @Insert("insert into record(Amount,CategoryID,Type,Status,CreatedAt,UpdatedAt,Note) values(#{Amount},#{CategoryID},#{Type},#{Status},NOW(),NOW(),#{Note})")
    void addRecord(@Param("Amount")String Amount,@Param("CategoryID")String CategoryID,@Param("Type")String Type,@Param("Status")String Status,@Param("Note")String Note);
    //修改
    @Update("update record set Amount = #{Amount},CategoryID = #{CategoryID},Type = #{Type},Status = #{Status},UpdatedAt = NOW(),Note = #{Note} where id = #{id}")
    void updateRecord(@Param("id")String id,@Param("Amount")String Amount,@Param("CategoryID")String CategoryID,@Param("Type")String Type,@Param("Status")String Status,@Param("Note")String Note);
    //查找
    @Select("select ID,Amount,CategoryID,Type,Status,CreatedAt,UpdatedAt,Note from record where ID = #{search} or Amount = #{search} or CategoryID = #{search} or Type = #{search} or Status = #{search} or CreatedAt = #{search} or UpdatedAt = #{search} or Note = #{search}")
    List<Record> getRecordListBySearch(@Param("search")String search);
    //修改页面：表单输入框里显示原来的数据，方便用户修改（下拉框涉及到另一张表不知道咋做）
    @Select("select Amount,Type,Status,Note from record where id =#{id}")
    List<Record> getPreUpdateRecordList(@Param("id")String id);
}

