package Week2;

public class class5 {
    String t;
    class5()
    {


        System.out.println(" t: "+t);
    }
    class5(String t)
    {


        this.t=t;
        System.out.println(" t: "+t);
    }
    public static void main(String []args)
    {
        String t;
        //System.out.println(t);
        class5 cl= new class5();
        class5 cl2= new class5("a");
    }
}
