/**
 * Created by Administrator on 2018/10/8.
 */
public class Sol918 {
    public static void main(String[]args)
    {

        Sol918 sol=new Sol918();
        System.out.println( sol.maxSubarraySumCircular2(new int[]{5,-3,2,4,-5,5}));

    }

    public int maxSubarraySumCircular(int[] A) {
        int n=A.length;

       // int i=0,j=n-1;
        //int res=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=A[i];

        int res=sum;
       for(int i=0;i<n;i++)
       {

           int start=0;
           for(int j=i;j<n;j++)
           {
               start+=A[j];
               //System.out.println(start);
               if(i==0&&j==n-1)
                   continue;
                  res=Math.max(res,Math.max(start,sum-start));

               //System.out.println(res);
           }


       }
        return res;

    }
    public int maxSubarraySumCircular2(int[] A) {
        int n = A.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=A[i];

        int res=sum;
        int prev=0;
        for(int i=0;i<n;i++) {
           if(prev >=0)
               prev+=A[i];
            res=Math.max(res,prev);
           if(prev<0)
           {
               prev=0;
           }
        }
        prev=0;
        for(int i=0;i<n;i++) {
            if(prev <=0)
                prev+=A[i];
            if(sum==prev)
                continue;
            res=Math.max(res,sum-prev);
            if(prev>0)
            {
                prev=0;
            }
        }

        return res;
    }
}
