package Week1;

import java.util.HashSet;
import java.util.Set;
public class Sol929 {

    public int numUniqueEmails(String[] emails) {


        Set<String>set=new HashSet<String>();
        for (String st:emails){

            char[]ss =st.toCharArray();
            String temp="";
            boolean po=false;
            boolean add=false;
            for(int i=0;i<ss.length;i++)
            {
                if(ss[i]=='@')
                {
                    temp+=st.substring(i);
                    break;
                }
                if(add==true|po==true)
                {
                    continue;
                }
                if(ss[i]=='+')
                {
                    add=true;
                    continue;
                }
                if(ss[i]=='.')
                {
                    add=true;
                    continue;
                }
                temp+=ss[i];


            }





            set.add(temp);

        }


        return set.size();

    }


  public static void   main(String args[]){

        String[] email=  {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
         Sol929 sol929=new Sol929();
         System.out.println(sol929.numUniqueEmails(email));

    }

}
