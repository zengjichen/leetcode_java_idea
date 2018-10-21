


public class Sol926 {
    public static void main(String[]args)
    {

        Sol926  sol=new Sol926();
        System.out.println( sol.minFlipsMonoIncr("00011000"));

    }
    public int minFlipsMonoIncr(String S) {



        char []st=S.toCharArray();
        int[]A=new int[st.length+1];
        int[]B=new int[st.length+1];
        A[0]=0;
        B[0]=0;

        for(int i=0;i<st.length;i++)
        {
            A[i+1]=A[i];
            B[i+1]=B[i];
            if(st[i]=='0')

                A[i+1]++;
            else
                B[i+1]++;


            //System.out.println(A[i+1]+" ---"+B[i+1]);
        }

        int res=st.length-B[st.length];// 全1
        for(int i=0;i<st.length;i++)
        {
            // 0->1

              res=Math.min(res,(B[i]+A[st.length]-A[i])); //0-1





          System.out.println(res+"----------"+i);
        }

        return  res;
    }


}
