import java.util.Arrays;

//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//        必须原地修改，只允许使用额外常数空间。
//
//        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1

public class Lc31 {
    public void nextPermutation(int[] nums) {
        int l = nums.length;


        for(int i=0;i<l-1;i++){

            //从后往前找到第一个升序序列[i,i+1]
            if(nums[l-i-1]>nums[l-i-2]){
                int k = l-i-1;
                for(int j=l-1;j>l-i-2;j--){

                    //从后往前找到一个比nums[i]大的最小的数
                    if(nums[j]>nums[l-i-2] && nums[j]<nums[k]){
                        k=j;

                    }
                }

                //交换
                int temp = nums[k];
                nums[k] = nums[l-i-2];
                nums[l-i-2] = temp;

                //对i以后的数排序
                Arrays.sort(nums,l-i-1,l);
                break;
            }

            //遍历完未找到升序序列，则说明整个数组都降序。
            if(i==l-2) Arrays.sort(nums);
        }
    }

    //改进
    public void nextPermutation1(int[] nums) {
        int l = nums.length;

        //从后往前找第一个升序对(i,i+1)
        for(int i=0;i<l-1;i++){


            if(nums[l-i-1]>nums[l-i-2]){
                int k = l-i-1;

                //从后往前找第一个大于nums[i]的数
                for(int j=l-1;j>l-i-2;j--){
                    if(nums[j]>nums[l-i-2]){
                        k=j;
                        break;
                    }
                }

                // nums[k] = nums[l-i-2]^nums[k];
                // nums[l-i-2] = nums[l-i-2]^nums[k];
                // nums[k] = nums[l-i-2]^nums[k];

                swap(nums,k,l-i-2);

                //(i+1,l-1)一定是降序的，直接逆序
                reverse(nums,l-i-1,l-1);
                break;
            }

            //直接逆序比排序快
            if(i==l-2) reverse(nums,0,nums.length-1);
        }
    }

    public void swap(int[] k,int a,int b){
        k[a] = k[a] ^ k[b];
        k[b] = k[a] ^ k[b];
        k[a] = k[a] ^ k[b];
    }

    public void reverse(int[] a,int l,int r){

        while(l<r){
            swap(a,l,r);
            l++;
            r--;
        }
    }
}
