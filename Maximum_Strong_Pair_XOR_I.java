import java.util.List;

class Solution {
    public int maximumStrongPairXor(List<Integer> nums) {
        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            for (int y : nums) {
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    ans = Math.max(ans, x ^ y);
                }
            }
        }
        return ans;
    }
}
