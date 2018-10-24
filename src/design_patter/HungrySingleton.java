package design_patter;
/**
 * 饿汉式
 * @author Lsj
 */
public class HungrySingleton {

    private static final String CLASS_NAME = "HungrySingleton";

    private static final HungrySingleton instance = new HungrySingleton();

    static{
        System.out.println("类加载时创建:"+instance);//这里可以看到类加载后，优先加载上方的静态成员变量
    }

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(HungrySingleton.CLASS_NAME);//可以看到，这里仅仅是打印HungrySingleton的静态常量，但实例依然被初始化了。
        System.out.println("==========分割线==========");
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance1);
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance2);
    }

}