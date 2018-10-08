import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by Administrator on 2018/9/23.
 */
public class sol720 {




    public static void main(String []args)
    {

        Solution720 sol=new Solution720();
        String a[]={"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println( sol.longestWord(a));
/*
*
* abc
bac
ab
ad
ba
sb
*
* */

        System.out.println("sb");
    }

}
class Solution720 {
    public String longestWord(String[] words) {

        Comparator cmp = new MyComparator();
        Arrays.sort(words,cmp);

        for( String word:words)
            System.out.println(word);


        HashSet<String>dict=new HashSet<String>();
        for( String word:words)
            dict.add(word);
        for(String word :words)
        {
            String prefix="";
            boolean valid=true;
            for(int i=0;i<word.length()-1&&valid;++i)
            {

                prefix+=word.charAt(i);
                if(!dict.contains(prefix))
                    valid=false;
            }
            if(valid)
                return word;
        }

        return "";

    }

}

// Comparator cmp = new MyComparator();
//Arrays.sort(a, cmp);
//Comparator是一个接口，所以这里我们自己定义的类MyComparator要implents该接口
//而不是extends Comparator
class MyComparator implements Comparator<String> {
    // @Override
    public int compare(String o1, String o2) {
        //如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值，
        //这样颠倒一下，就可以实现反向排序了
        if (o1.length() != o2.length())
        {
            return o1.length() <o2.length()? 1:-1;
        }
        else{

            return   o1.compareTo(o2)>0 ?1:-1;
        }

    }
}