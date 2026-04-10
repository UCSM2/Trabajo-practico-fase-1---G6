package Torres;

public class Mochila {

    public static int resolver(int[] peso, int[] valor, int cap) {

        int n = peso.length;
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= cap; w++) {

                if (peso[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        valor[i - 1] + dp[i - 1][w - peso[i - 1]]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][cap];
    }
}