package Week2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sol933 {

    public static void main(String []args)
    {
        RecentCounter r=new RecentCounter();

        r.ping(1);
        r.ping(100);
        r.ping(3001);
        r.ping(3002);
    }

}
class RecentCounter {

    public  int []arr;
    public  int tn=10001;
    public  int n;

    public RecentCounter() {

        arr=new int [tn];
        n=0;

    }

    public int ping(int t) {


        int res=1;
        arr[n]=t;
        System.out.println(n);
        for(int i=0;i<n;i++)
        {
            System.out.println("arr[i]:"+n);
            if(arr[i]>=t-3000&&arr[i]<=t)
                res++;
        }
        n++;

        System.out.println(res);
        return res;

    }
}