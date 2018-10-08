import java.util.Arrays;

/**
 * Created by Administrator on 2018/10/8.
 */
class Solution917 {


    public static void main(String[]args)
    {

       Solution917  sol=new Solution917();
      System.out.println( sol.reverseOnlyLetters("ab_c12"));

    }
    public String reverseOnlyLetters(String S) {

        char[] arr = S.toCharArray();
        for(int i=0,j=arr.length-1;i<=j;i++,j--)
        {
            while(i<arr.length-1&&valid(arr[i])==false)
                i++;

            while(j>=0&&valid(arr[j])==false)
                j--;
            if(i<=j)
            {
                char temp;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

            }


        }

        String res="";
        for(char st:arr)
            res+=st;
        return res;
    }


    boolean valid(char s)
    {
        if(s<='z'&&s>='a')

            return true;
        if(s>='A'&&s<='Z')
            return true;
        return false;

    }
}