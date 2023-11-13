class Solution:
    def helper(self, A, B):
        n = len(A)
        max1 = A[n-1]
        max2 = B[n-1]
        res = 0
        for i in range(n):
            if A[i] <= max1 and B[i] <= max2:
                continue
            elif A[i] <= max2 and B[i] <= max1:
                res += 1
            else:
                return float('inf') - 1
        return res
    
    def minOperations(self, nums1, nums2):
        res = 0
        n = len(nums1)
        res = self.helper(nums1, nums2)
        nums1[n-1], nums2[n-1] = nums2[n-1], nums1[n-1]
        res = min(res, 1 + self.helper(nums1, nums2))
        if res >= float('inf') - 1:
            return -1
        return res


