package com.atguigu.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author shkstart
 * @create 2019-02-15 下午 2:50
 */
public class  BankTest{

}

class Bank{

    private  Bank(){};

    private  static  Bank  instance = null;

    public  static  synchronized Bank  getInstance(){
//


        //方式二：效率更高
        if(instance==null){
            synchronized (Bank.class){
                if(instance==null){
                    instance = new Bank();
                }
            }
        }
        return  instance;

    }
}