package design_patter;

/**
 * 通过双重检查的方式创建及获取单例对象
 * @author Lsj
 */
public class DoubleCheckedLockingSingleton {

    private volatile static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLockingSingleton.class) {
                if(instance == null){
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

}

/**
 * 以静态内部类的方式来创建获取单例对象
 * @author Lsj
 *
 */
 class InnerSingleton {

    private InnerSingleton(){
    }

    public static InnerSingleton getInstance(){
        return InnerSingleton.InnerClass.instance;
    }

    static class InnerClass {
        private static InnerSingleton instance = new InnerSingleton();
    }

}

/**
 * 通过枚举实现单例模式
 * @author Lsj
 *
 */
 class EnumSingleton {

    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    enum Singleton {
        INSTANCE;
        private EnumSingleton instance;

        private Singleton(){
            instance = new EnumSingleton();
        }

        private EnumSingleton getInstance(){
            return instance;
        }
    }

}