package com.donnie.grow.basic.proxy;

public class ProxyMain {

    public static void main(String[] args){
        UserDao userDao = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();

        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        IUserDao userDao1 = (IUserDao) proxyFactory.getProxyInstance();
        userDao1.save();

        CgUserDao cgUserDao = new CgUserDao();
        CgUserDao cgUserDaoProxy = (CgUserDao) new CglibProxyFactory(cgUserDao).getProxyInstance();
        cgUserDaoProxy.save();
    }
}
