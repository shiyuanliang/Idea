package synchronize_learning.com.atguigu.exer;

/**
 * 银行有一个账户。
 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。

    分析：
 1.是否是多线程问题？ 是，两个储户线程
 2.是否有共享数据？ 有，账户（或账户余额）
 3.是否有线程安全问题？有
 4.需要考虑如何解决线程安全问题？同步机制：有三种方式。

 * @author shkstart
 * @create 2019-02-15 下午 3:54
 */
class  Account{
    private int  account=0;

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}

class  Customer extends  Thread{
    private  Account account;
    private  int myMoney =300000;

    public  Customer(Account account){
        this.account = account;
    }

    private void saveMoney(int money) {
        int temp;
        temp = account.getAccount();
        temp += money;
        account.setAccount(temp);
        myMoney -=money;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Customer.class) {
                if (myMoney > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    saveMoney(1000);
                    System.out.println(this.getName()+account.getAccount());
                }else{
                    break;
                }
            }
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();
        Customer cust1 = new Customer(acct);
        Customer cust2 = new Customer(acct);
        cust1.setName("甲");
        cust2.setName("乙");
        cust1.start();
        cust2.start();
    }
}
