class Solution {
public:
    int maximumStrongPairXor(vector<int>& nums) {
        int ans=INT_MIN;
        for(int x:nums)
        {
            for(int y:nums)
            {
                if(abs(x-y)<=min(x,y))
                {
                    ans=max(ans,x^y);
                }
            }
        }
        return ans;

        
    }
};
