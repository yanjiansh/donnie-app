package com.donnie.grow.proxy;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("---------data saved!!--------");
    }
}
