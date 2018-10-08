/**
 * Created by Administrator on 2018/9/23.
 */
public class sol639 {
    public static void main(String []args) {

        Solution_639 sol = new Solution_639();
       System.out.println( sol.numDecodings("**********1111111111"));
        String s="1*";
        System.out.println((109 + 7));

      //  System.out.print(s.substring(0,1)+s.substring(2));

    }
}


    class Solution_639 {
        public int numDecodings(String s) {
            if(s.equals("*"))
                return 9;
            if(s.equals("0"))
                return 0;

            if(s.length()<=1)
                return 1;


            char start=s.charAt(0);
            char next=s.charAt(1);
            if(start=='0')
                return 0;
            if(start=='1')
            {

                if(next=='*')
                {
                    // 1 看作单个字符，11-19一组
                    return (9*numDecodings(s.substring(2))%(1000000000 + 7)+numDecodings(s.substring(1))%(1000000000 + 7))%(1000000000 + 7);
                }
                else {
                    return (numDecodings(s.substring(1))%(1000000000 + 7)+numDecodings(s.substring(2))%(1000000000 + 7))%(1000000000 + 7);
                }

            }

            if(start=='2')
            {
                if(next-'0'<=6&&next-'0'>=1)
                {
                    // System.out.print(s.substring(1)+" "+s.substring(2));
                    return (numDecodings(s.substring(1))%(1000000000 + 7)+numDecodings(s.substring(2)) %(1000000000 + 7)) %(1000000000 + 7);
                }
                else if(next=='*'){
                    return numDecodings(s.substring(2))%(1000000000 + 7)*6+numDecodings(s.substring( 1)) %(1000000000 + 7);

                }
                else {
                    return numDecodings(s.substring(2)) %(1000000000 + 7);
                }
            }
            if(start=='*')
            {
                //System.out.println(s.substring(1));
                //System.out.println(numDecodings(s.substring(1)));
                return (numDecodings(s.substring(1))*7%(1000000000 + 7)+numDecodings('1'+s.substring(1))%(1000000000 + 7)+numDecodings('2'+s.substring(1)))%(1000000000 + 7);
            }



            return (numDecodings(s.substring(1)))%(1000000000 + 7);
        }
    }