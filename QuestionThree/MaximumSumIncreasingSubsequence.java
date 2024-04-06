public class MaximumSumIncreasingSubsequence {

    static int maxSumIS(int arr[], int n) {
        int dp[] = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++)
            dp[i] = arr[i];


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (max < dp[i])
                max = dp[i];

        return max;
    }
    public static void main(String args[]) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing subsequence is " +
                maxSumIS(arr, n));
    }
}
