package com.donnie.grow.proxy;

public class UserDaoProxy implements IUserDao {
    private UserDao target;

    public UserDaoProxy(UserDao userDao){
        this.target = userDao;
    }
    @Override
    public void save() {
        System.out.println("---------start--------");
        target.save();
        System.out.println("---------end--------");
    }
}
