package com.donnie.grow.basic.proxy;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("---------data saved!!--------");
    }
}
