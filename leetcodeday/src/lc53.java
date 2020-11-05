public class lc53 {
    //leetcode53 https://leetcode-cn.com/problems/maximum-subarray/
    public int maxSubArray1(int[] nums) {//动态规划
        int pre=0;int max=nums[0];
        for(int x:nums){
            pre=Math.max(pre+x,x);
            max=Math.max(max,pre);//动态数组
        }
        return max;

    }

    //强行分治法
    public class status{
        public int isum,rsum,lsum,maxsum;
        public status(int isum,int rsum,int lsum,int maxsum){
            this.isum=isum;
            this.rsum=rsum;
            this.lsum=lsum;
            this.maxsum=maxsum;
        }
    }
    public int maxSubArray2(int[] nums) {
        return getSum(0,nums.length-1,nums).maxsum;
    }
    public status updatesum(status l,status r){
        // status a = new status(0,0,0,0);

        int isum=l.isum+r.isum;
        int lsum=Math.max(l.lsum,l.isum+r.lsum);
        int rsum=Math.max(r.rsum,r.isum+l.rsum);
        int maxsum=Math.max(Math.max(l.maxsum,r.maxsum),l.rsum+r.lsum);
        return new status(isum,rsum,lsum,maxsum);

    }

    public status getSum(int l,int r,int[] nums){
        if(l==r){
            return new status(nums[l],nums[l],nums[l],nums[l]);
        }
        int mid=(l+r)/2;
        return updatesum(getSum(l,mid,nums),getSum(mid+1,r,nums));



    }
}
