
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
//        对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//
//        你可以返回任何满足上述条件的数组作为答案。
//
//        示例：
//
//        输入：[4,2,5,7]
//        输出：[4,5,2,7]
//        解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。

public class Lc922 {
    public int[] sortArrayByParityII(int[] A) {
        int l = A.length-1;
        int j = 0;
        int i = 1;
        while(j<A.length){

            //找第一个是奇数的A[j]
            while(j<=l-1 && ((A[j] & 1) == 0)){
                j+=2;
            }

            //找第一个是偶数的A[i]
            while(i<=l && ((A[i] & 1) == 1)){
                i+=2;
            }
            if(j>l-1 || i>l){
                break;
            }
            int temp = A[j];
            A[j] = A[i];
            A[i] = temp;

        }
        return A;

    }
}
