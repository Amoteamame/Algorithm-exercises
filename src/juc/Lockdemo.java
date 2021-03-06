package juc;

import java.util.concurrent.TimeUnit;

/**
 * Created by htFly on 2020/7/1.
 */

class Phone{
    public static synchronized void sendEmail() throws Exception{
//        Thread.sleep(4000); // 暂停4秒钟
        TimeUnit.SECONDS.sleep(4);
        System.out.println("******senEmail*****");
    }

    public  synchronized void sendSMS() throws Exception{
        System.out.println("******sendSMS*****");
    }
    public void sayHello()throws Exception{
        System.out.println("hello!!!");
    }
}

/**
 * 1 标准访问，先打印哪个
 * 2 暂停4秒钟
 * 3 新增普通sayHello方法，先打印哪个
 * 4 两部手机，先打印哪个
 * 5 两个静态同步方法
 * 6 两个静态同步方法，两部手机
 * 7 一个静态，一个普通同步
 * 8 一个静态，一个普通同步，两个手机
 *
 * 一个对象里面如果又多个synchronized方法，某一个时刻内，只要一个线城去调用其中的一个syn方法，其他线城都只能等待。
 * 即，某个时刻内，只能有唯一的一个线城去访问这些syn方法
 *
 * 锁的是当前对象this，被锁定后，其他的线城都不能进入到当前对象的其他syn方法。
 *
 * 加个普通方法后发现和锁无关
 *
 * 换成两个对象后，不是同一把锁了，情况变化。
 *
 * 静态同步锁，就是全局锁
 *
 * 所有非静态同步方法都是同一把锁-实例对象本身。
 * syn实现同步的基础：java中每一个对象都可以作为锁。
 * 具体表现为3种形式：
 * 对于普通同步方法，琐是当前实例对象。
 * 对于同步方法快，锁是syn括号里配置的对象。
 * 对于静态同步方法，锁是当前类的class对象。
 * 当一个线城试图访问同步代码块时，它首先必须得到锁，退出或抛出异常时必须释放锁。
 *
 * 也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，
 * 可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，所以无需等待该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁。
 *
 * 所有的静态同步方法用的也是同一把锁-类对象本身。
 * 这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间是不会有竞争条件的。
 * 但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁。
 * 而不管是同一个实例对象静态同步方法之间，还是不同实例静态同步方法之间，只要他们是同一个类的实例对象。
 *
 */
public class Lockdemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try{phone.sendEmail();} catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(100);

        new Thread(()->{
            try{
//                phone.sendSMS();
//                phone.sayHello();
//                phone2.sendSMS();
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

    }
}
