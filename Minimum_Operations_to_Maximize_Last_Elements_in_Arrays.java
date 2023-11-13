class Solution {
    public int helper(List<Integer> A, List<Integer> B) {
        int n = A.size();
        int max1 = A.get(n - 1);
        int max2 = B.get(n - 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) <= max1 && B.get(i) <= max2) {
                continue;
            } else if (A.get(i) <= max2 && B.get(i) <= max1) {
                res++;
            } else {
                return Integer.MAX_VALUE - 1;
            }
        }
        return res;
    }
    
    public int minOperations(List<Integer> nums1, List<Integer> nums2) {
        int res;
        int n = nums1.size();
        res = helper(nums1, nums2);
        Collections.swap(nums1, n - 1, n - 1);
        res = Math.min(res, 1 + helper(nums1, nums2));
        if (res >= Integer.MAX_VALUE - 1)
            return -1;
        return res;
    }
}
