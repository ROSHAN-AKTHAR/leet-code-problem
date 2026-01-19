class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Step 1: Prefix Sum
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        // Step 2: Binary Search
        int low = 0, high = Math.min(m, n);
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (isPossible(pre, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // Step 3: Check if any k x k square is valid
    private boolean isPossible(int[][] pre, int k, int threshold) {
        for (int i = 0; i + k < pre.length; i++) {
            for (int j = 0; j + k < pre[0].length; j++) {
                int sum = pre[i + k][j + k]
                        - pre[i][j + k]
                        - pre[i + k][j]
                        + pre[i][j];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
