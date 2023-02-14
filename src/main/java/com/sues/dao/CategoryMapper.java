package com.sues.dao;

import com.sues.pojo.Category;
import com.sues.pojo.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryMapper {

    @Results({
            @Result(column = "ID",property = "ID"),
            @Result(column = "OwnerID",property = "OwnerID"),
            @Result(column = "Name",property = "Name"),
            @Result(column = "Type",property = "Type"),
            @Result(column = "Status",property = "Status"),
            @Result(column = "CreatedAt",property = "CreatedAt"),
            @Result(column = "UpdatedAt",property = "UpdatedAt")
    })

    //增加修改账单记录页面里的下拉框内容的填充
    @Select("select ID,Name from category")
    List<Category> getCategoryName();

    //分类列表的展示
    @Select("select ID,Name,Type,Status,CreatedAt,UpdatedAt from category")
    List<Category> getCategory();

    //添加
    @Insert("insert into category(Name,Type,Status,CreatedAt,UpdatedAt) values(#{Name},#{Type},#{Status},NOW(),NOW())")
    void addCategory(@Param("Name")String Name,@Param("Type")String Type,@Param("Status")String Status);

    //删除
    @Delete("delete from category where id = #{id}")
    void deleteCategory(@Param("id")String id);

    //修改
    @Update("update category set Name = #{Name},Type = #{Type},Status = #{Status},UpdatedAt = NOW() where id = #{id}")
    void updateCategory(@Param("Name")String Name,@Param("Type")String Type,@Param("Status")String Status,@Param("id")String id);

    //查找
    @Select("select ID,Name,Type,Status,CreatedAt,UpdatedAt from category where ID = #{search} or Name = #{search} or Type = #{search} or Status = #{search} or CreatedAt = #{search} or UpdatedAt = #{search}")
    List<Category> getCategoryListBySearch(@Param("search")String search);

    //修改页面：表单输入框里显示原来的数据，方便用户修改
    @Select("select Name,Type,Status from category where id =#{id}")
    List<Category> getPreUpdateCategoryList(@Param("id")String id);
}
