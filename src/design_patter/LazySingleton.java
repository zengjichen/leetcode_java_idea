package design_patter;
import java.util.concurrent.CountDownLatch;
import  java.util.concurrent.TimeUnit;
/**
 * 懒汉式
 * @author Lsj
 */
public class LazySingleton {

    private static LazySingleton instance;

    /**
     * 获取单一实例对象—非同步方法
     * @return
     */
    public static LazySingleton getInstance(){
        if(instance == null){
            try {
                TimeUnit.NANOSECONDS.sleep(1);//为了使模拟效果更直观，这里延时1ms，具体看时序图
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }
/**
        30      * 增加同步锁
31      * 避免多线程环境下并发产生多个实例可能的同时，会带来性能上的损耗。
            32      * 事实上只有第一次创建时需要这么做，但后续依然通过加锁获取单例对象就有点因小失大了。
            33      * @return
            34      */
    public synchronized static LazySingleton getInstanceSyn(){
                 if(instance == null){
                       try {
                              TimeUnit.MILLISECONDS.sleep(1);//为了使模拟效果更直观，这里延时1ms，具体看时序图
                       } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                          e.printStackTrace();
                          }
                   instance = new LazySingleton();
                   }
                   return instance;
        }
    public static  void main(String []args ) throws InterruptedException{
        CountDownLatch startSignal=new CountDownLatch(1);
        for(int i=0;i<2;i++)// 2个线程
        {
            Thread t=new Thread(new MyThread(startSignal));
            t.setName("thread "+i);
            t.start();
        }
        Thread.sleep(1000);
        startSignal.countDown();
    }

}
class MyThread implements Runnable{
    private final CountDownLatch startSignal;
    public MyThread(CountDownLatch startSignal) {
        this.startSignal=startSignal;
    }

    @Override
    public void run() {

        try {
        System.out.println("current thread:" +Thread.currentThread().getName()+" is waiting");

            startSignal.await();//wait();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        LazySingleton l = LazySingleton.getInstance();
          System.out.println(l);
    }
}