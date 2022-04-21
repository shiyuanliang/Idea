package synchronize_learning.com.atguigu.java2;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程的安全问题？同步机制,有三种方法
 * 4. 是否涉及线程的通信？是
 *
 * @author shkstart
 * @create 2019-02-15 下午 4:48
 */




/// 这里相当于是用到了两个同步锁  一个是消费者的  一个是生产者的  其实现的意义是：多个生产者不能同时生产
// （多个消费者不能同时消费），但是消费者与生产者能够同时操作，加上wait也只是将各自的同样的wait了，例如，消费者中的wait
// 其实就是说的是现在货不足了，你先不消费了，此时他放了消费者的锁，其他的消费者抢到锁后，就再判断 这个时候如果有货他就拿走了
//  真的是有趣的现象，意思就是等的那个人就不可能拿到那个货 一定被别人抢了
class  Clerk {
    private  int stock =0;
    public  final static int MAX_PRO=20;

    public  void salePro(){
       stock--;
    }
    public  void getPro(){
        stock++;
    }

    public int getStock() {
        return stock;
    }
}

class  Customer extends   Thread{
    private  Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (clerk) {
                clerk.notifyAll();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (clerk.getStock() > 0) {
                    clerk.salePro();
                    System.out.println(Thread.currentThread().getName() + "买一个商品，此时Clerk的库存为" + clerk.getStock());
                }else{
                    System.out.println(Thread.currentThread().getName()+"此时没有产品，请耐心等待进货");
                    try {
                        clerk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class  Productor extends   Thread{
    private  Clerk clerk;

    Productor(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (clerk) {
                clerk.notifyAll();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (clerk.getStock() < 20) {
                    clerk.getPro();
                    System.out.println(Thread.currentThread().getName() + "向clerk进货一个商品，此时Clerk的库存为" + clerk.getStock());
                }else{
                    System.out.println("库存充足无需进货");
                    try {
                        clerk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public  class  ProductTest{
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Customer cust1 = new Customer(clerk);
        Customer cust2 = new Customer(clerk);
        Customer cust3 = new Customer(clerk);


        Productor pro1 = new Productor(clerk);
        Productor pro2 = new Productor(clerk);
//        Productor pro3 = new Productor(clerk);
        cust1.setName("顾客1");
        cust2.setName("顾客2");
        cust3.setName("顾客3");
        pro1.setName("生产家1");
        pro2.setName("生产家2");
//        pro3.setName("生产家3");
        cust1.start();
        cust2.start();
        cust3.start();

        pro1.start();
        pro2.start();
//        pro3.start();
    }
}