package Week2;

public class Sol934 {


    public static void main(String []args)
    {
        Solution sol=new Solution();
        int[][]A={{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        int res=sol.shortestBridge(A);

        System.out.println(res);
    }


}
class Solution {
    public  int [][]arr;
    public   int n,m;
    public   int[]directx={-1,1,0,0};
    public   int[]directy={0,0,-1,1};
    public  int[][]go;
    public   int island,res;
    public int shortestBridge(int[][] A) {

        arr=A;
        m=arr.length;
        if(m<=0)
            return 0;
        n=arr[0].length;

        res=m*n;
        go=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++) {
                if(arr[i][j]==1)
                    island++;
            }

        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                {

                   // System.out.println("main******@@@@@@@@@@#");

                    help(A,1,0,i,j);

                }
               // res=Math.min(res,used);
            }
        }
        return res;
    }
    public void help(int [][] ar,int cur,int used,int i,int j)
    {

        //System.out.println(island);
       // System.out.println("help@@@@@@@@@@#");
        if(cur==island)
        {

            if(res>used)
                System.out.println("help@@@@@@@@@@: "+used);
            res=Math.min(res,used);

            return;
        }

        if(go[i][j]==1)
        {
          //  System.out.println("cur return go i,j: "+i+" "+j);
            return ;
        }
        go[i][j]=1;

        for(int st=0;st<4;st++)
        {
            if(i+directx[st]>=0&&i+directx[st]<m)
            {

                if(j+directy[st]>=0&&j+directy[st]<n)
                {
                    int dx=i+directx[st];
                    int dy=j+directy[st];
                    if(go[dx][dy]==0) {

                       // System.out.println("cur i,j: " + i + " " + j);

                        //System.out.println("cur dx,dy: " + dx + " " + dy + " " + ar[dx][dy] + " cur:" + cur);


                        if (ar[dx][dy] == 1) {
                            cur = cur + 1;
                            //  System.out.println(dx+" "+dy);
                            help(ar, cur, used, dx, dy);
                        } else {
                            // System.out.println(dx+" "+dy);
                            ar[dx][dy] = 1;
                            help(ar, cur, used + 1, dx, dy);
                            ar[dx][dy] = 0;
                        }
                    }
                }
            }

        }
        go[i][j]=0;


    }

}