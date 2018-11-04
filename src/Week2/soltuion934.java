package Week2;
import java.util.*;
public class soltuion934 {
}
/**
 *
 * Approach 1: Dynamic Programming
 *         Intuition
 *
 *         Let f(start, n) be the number of ways to dial an n digit number,
 *         where the knight starts at square start.
 *         We can create a recursion, writing this in terms of f(x, n-1)'s.
 *
 *         Algorithm
 *
 *         By hand or otherwise, have a way to query what moves are available at each square.
 *         This implies the exact recursion for f.
 *         For example, from 1 we can move to 6, 8, so f(1, n) = f(6, n-1) + f(8, n-1).
 *
 *         After, let's keep track of dp[start] = f(start, n), and update it for each n from 1, 2, ..., N.
 *
 *         At the end, the answer is f(0, N) + f(1, N) + ... + f(9, N) = sum(dp).
 *           def knightDialer(self, N):
 *         mod = 10**9 + 7
 *         if N == 1: return 10
 *         M = np.matrix([[0, 0, 0, 0, 1, 0, 1, 0, 0, 0],
 *                        [0, 0, 0, 0, 0, 0, 1, 0, 1, 0],
 *                        [0, 0, 0, 0, 0, 0, 0, 1, 0, 1],
 *                        [0, 0, 0, 0, 1, 0, 0, 0, 1, 0],
 *                        [1, 0, 0, 1, 0, 0, 0, 0, 0, 1],
 *                        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
 *                        [1, 1, 0, 0, 0, 0, 0, 1, 0, 0],
 *                        [0, 0, 1, 0, 0, 0, 1, 0, 0, 0],
 *                        [0, 1, 0, 1, 0, 0, 0, 0, 0, 0],
 *                        [0, 0, 1, 0, 1, 0, 0, 0, 0, 0]])
 *         res, N = 1, N - 1
 *         while N:
 *             if N % 2: res = res * M % mod
 *             M = M * M % mod
 *             N /= 2
 *         return int(np.sum(res)) % mod
 */
class Solution_934 {
    public int knightDialer(int N) {
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] memo = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += helper(N, i, map, memo);
            result %= (int)1e9 + 7;
        }
        return result;
    }
    private int helper(int N, int start, int[][] map, int[][] memo) {
        if (N == 1) {
            return 1;
        }
        if (memo[N][start] > -1) {
            return memo[N][start];
        }
        memo[N][start] = 0;
        for (int next : map[start]) {
            memo[N][start] += helper(N - 1, next, map, memo);
            memo[N][start] %= (int)1e9 + 7;
        }
        return memo[N][start];
    }
}