import java.util.stream.IntStream;

/**
 * Created by Administrator on 2018/10/3.
 */
public class sol724 {

    public static void main(String []args) {

        Solution_724 sol = new Solution_724();
        System.out.println( sol);


        //  System.out.print(s.substring(0,1)+s.substring(2));

    }



}
class Solution_724 {
    public int pivotIndex(int[] nums) {
        int sum= IntStream.of(nums).sum();
        int left=0;
        int right=sum;
        for(int i=0;i<nums.length;i++)
        {
            right-=nums[i];
            if(left==right)
                return i;

            left+=nums[i];
        }

return 0;

    }
}