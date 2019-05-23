package com.donnie.grow.demo;

/**
 * JAVA中sleep()和wait()区别
 * @author yanjiansh
 * @date 2019/5/23 22:04
 */
public class SleepWaitDistinguish {

    public static void main(String[] args) {
        new Thread(new Task1()).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Task2()).start();

    }

    private static class Task1 implements Runnable {

        @Override
        public void run() {
            synchronized (SleepWaitDistinguish.class) {
                System.out.println("Task1 start...");
                System.out.println("Task1 is waiting...");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    SleepWaitDistinguish.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Task1 is go on...");
                System.out.println("Task1 is over!!!");
            }
        }
    }

    private static class Task2 implements Runnable {

        @Override
        public void run() {
            synchronized (SleepWaitDistinguish.class) {
                System.out.println("Task2 start...");
                System.out.println("Task2 is waiting...");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                //==================
                //区别
                //如果我们把代码：SleepWaitDistinguish.class.notify();给注释掉，
                //SleepWaitDistinguish.class调用了wait()方法，但是没有调用notify()方法，
                //则线程永远处于挂起状态。
                SleepWaitDistinguish.class.notify();
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Task2 is go on...");
                System.out.println("Task2 is over!!!");
            }
        }
    }
}
