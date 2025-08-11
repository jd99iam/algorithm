package dp;

public class TopDown {
    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n + 1];
        System.out.println(fibo(n,memo));
    }

    public static int fibo(int n, int[] memo) {
        if (n <= 2) return 1;
        if (memo[n] != 0) return memo[n];

        memo[n] = fibo(n - 1, memo) + fibo(n - 2, memo);
        return memo[n];
    }
}
