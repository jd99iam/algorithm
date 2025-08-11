package dp;

public class BottomUp {
    public static void main(String[] args) {

        System.out.println(bottomUp(10));

    }

    public static int bottomUp(int n) {
        if (n <= 2) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
