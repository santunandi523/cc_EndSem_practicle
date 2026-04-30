import java.util.Arrays;

public class Exp2 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);

        int includeFirst=find(0,nums.length-1,nums,dp);
        Arrays.fill(dp,-1);
        int notIncludeFirst=find(1,nums.length,nums,dp);
        return Math.max(includeFirst,notIncludeFirst);
        
    }
    public int find(int src,int end,int nums[],int[]dp){
        if(src>=end){
            return 0;
        }
        if(dp[src]!=-1){
            return dp[src];
        }

        int rob=nums[src]+find(src+2,end,nums,dp);
        int notRob=find(src+1,end,nums,dp);

        return dp[src]=Math.max(rob,notRob);
    }
}

