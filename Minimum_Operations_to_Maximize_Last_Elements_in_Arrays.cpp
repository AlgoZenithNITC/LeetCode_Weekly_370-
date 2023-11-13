class Solution {
public:
     int helper(vector<int>A,vector<int>B)
     {
         int n=A.size();
         int max1=A[n-1];
         int max2=B[n-1];
         int res=0;
         for(int i=0;i<n;i++)
         {
             if(A[i]<=max1 and B[i]<=max2)
             {
                 continue;
             }
             else if(A[i]<=max2 and B[i]<=max1)
             {
                 res++;
             }
             else
                 return INT_MAX-1;
         }
         return res;
     }
    int minOperations(vector<int>& nums1, vector<int>& nums2) {
        int res;
        int n=nums1.size();
        res=helper(nums1,nums2);
        swap(nums1[n-1],nums2[n-1]);
        res=min(res,1+helper(nums1,nums2));
        if(res>=INT_MAX-1)
            return -1;
        return res;
        
        
        
    }
};
