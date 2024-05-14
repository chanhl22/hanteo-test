package hanteo.hanteotest.test2.domain;

import java.util.List;

public class Test2Service {

    private static final long MOD = 1000000007;

    public int solution(int sum, List<Integer> coins) {
        long[] dp = new long[100001];
        dp[0] = 1;

        for (int coin : coins) {
            for (int change = coin; change < sum + 1; change++) {
                dp[change] = dp[change] + dp[change - coin];
            }
        }

        return (int) (dp[sum] % MOD);
    }

}
