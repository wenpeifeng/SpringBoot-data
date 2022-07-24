package com.ahead.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询
    @GetMapping ("/userList")
    public List<Map<String,Object>> getUserList(){
        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);
    }
    // 添加
    @GetMapping ("/addUser")
    public String addUser(){
        String sql = "insert into user(id, name,sex,age) values (7,'梅花','女',18)";
        jdbcTemplate.update(sql);
        return "addOk";
    }
    // 修改
    @GetMapping ("/editUser/{id}")
    public String editUser(@PathVariable("id")int id){
        String sql = "update user set name=?,age=? where id="+id;
        jdbcTemplate.update(sql,new Object[]{"梅花十三",20});
        return "updateOk";
    }
    // 删除
    @GetMapping ("/delUser/{id}")
    public String delUser(@PathVariable("id")int id){
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,id);
        return "delOk";
    }
}
