package Week1;

public class Sol930 {



        public int numSubarraysWithSum(int[] A, int S) {

            int n=A.length;
            //Integer suma[]=new Integer[9];
            int sum[]=new int[n];
//            for(int i=0;i<n;i++)
//            {
//                sum[i]+=A[i];
//
//            }
//            if(sum[n-1]==S)
//                return 1;
//            if(sum[n-1]<S)
//                return 0;

            int res=0;
            for(int i=0;i<n;i++)
            {
                int start=0;
                for(int j=i;j<n;j++)
                {
                    start+=A[j];
                    if(start>S)
                        break;
                    if(start==S)
                    {
                        res++;
                       // System.out.println(i+" "+j);
                    }

                }

            }



              return res;


        }

    public static void   main(String args[]){
            Sol930 sol930=new Sol930();
            int []A={1,0,1,0,1};
            System.out.println(sol930.numSubarraysWithSum(A,2));
    }

}
