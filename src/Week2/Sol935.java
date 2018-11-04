package Week2;

public class Sol935 {
}

  /**  What I basiclly did here is trying to reverse the whole operations.
        The operation token later will be more apperant than the operation token before.
   And we really don't care about the letters which are covered.

        *  *  *  *  *  *  *
        *  *  * |a  b  c  a|
        |a  b  c  a| b  c  a
        a |a  b  c  a| c  a
        We just try to match the stamp with the target.
   Since we do not care about the letters which are coverd by others,
   so we can apply a * match any letters. For example:

        "aabcaca" -> "a****ca" -> "*****ca"->"*******"
        It's just my contest code, needed to be revised.

class Solution {
    public:
    vector<int> movesToStamp(string stamp, string target) {
        vector<int> ans;
        vector<int> output;
        string str = target;
        string aim(target.length(),'*');
        while(str != aim){
            int tmp = remove(str,stamp);
            if(tmp == str.length()) return output;
            ans.push_back(tmp);
        }
        for(int iter=ans.size()-1;iter>=0;--iter) output.push_back(ans[iter]);
        return output;
    }
    int remove(string& str, string stamp){
        for(int iter=0;iter<str.length();++iter){
            int jter=0,tmp=iter;
            bool flag=false;
            while(jter<stamp.length() && tmp<str.length() && (str[tmp]=='*' || str[tmp]==stamp[jter])){
                if(str[tmp]==stamp[jter]) flag=true;
                tmp++;
                jter++;
            }
            if(jter==stamp.length() && flag){
                for(int kter=0;kter<stamp.length();++kter)
                    str[iter+kter]='*';
                return iter;
            }
        }
        return str.length();
    }
};

   Try to find a path of target,
   where path[i] equals to index of target[i] in stamp

   Example 1:
   Input: stamp = "abc", target = "ababc"
   path = [0,1,0,1,2]

   Example 2:
   Input: stamp = "aabcaca", target = "abca"
   path = [0,0,1,2,3,2,3]

   The rule is that,
   rule 1. path[i + 1] can equal to path[i] + 1
   It means target[i] and target[i+1] are on the same stamp.

   rule 2. path[i + 1] can equal to 0.
   It means t[i + 1] is the start of another stamp

   rule 3. if path[i] == stamp.size - 1, we reach the end of a stamp.
   Under this stamp, it's another stamp, but not necessary the start.
   path[i + 1] can equal to 0 ~ stamp.size - 1.

   Step 2:
   We need to change path to required moves.
   This can be a medium problem on the Leetcode.

   def movesToStamp(self, s, t):
   if s[0] != t[0] or s[-1] != t[-1]: return []
   n, m = len(s), len(t)
   path = [0] * m
   pos = collections.defaultdict(set)
   for i, c in enumerate(s): pos[c].add(i)

   def dfs(i, index):
   path[i] = index
   if i == m - 1: return index == n - 1
   nxt_index = set()
   if index == n - 1:  # rule 2
   nxt_index |= pos[t[i + 1]]
   if s[index + 1] == t[i + 1]:  # rule 0
   nxt_index.add(index + 1)
   if s[0] == t[i + 1]:  # rule 1
   nxt_index.add(0)
   return any(dfs(i + 1, j) for j in nxt_index)

   def path2res(path):
   down, up = [], []
   for i in range(len(path)):
   if path[i] == 0:
   up.append(i)
   elif i and path[i] - 1 != path[i - 1]:
   down.append(i - path[i])
   return down[::-1] + up

   if not dfs(0, 0): return []
   return path2res(path)
   **/