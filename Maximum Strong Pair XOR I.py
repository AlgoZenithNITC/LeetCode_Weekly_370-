class Solution:
    def maximumStrongPairXor(self, nums):
        ans = float('-inf')
        for x in nums:
            for y in nums:
                if abs(x-y) <= min(x, y):
                    ans = max(ans, x^y)
        return ans


