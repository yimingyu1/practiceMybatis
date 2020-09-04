package cn.mingyu.Dao;

import cn.mingyu.domain.User;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();
}
