import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//本题相当于topK
public class lc973 {

    //调用Arrays.sort 先排序，再返回前K个
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points,(a1,a2)->(a1[0]*a1[0]+a1[1]*a1[1])-(a2[0]*a2[0]+a2[1]*a2[1]));
        //等同于
//        Arrays.sort(points,new Comparator<int[]>(){
//            public int compare(int[] a,int[] b){
//                return a[0]*a[0] + a[1]*a[1] - b[0]*b[0]-b[1]*b[1];
//            }
//        });

        return Arrays.copyOfRange(points,0,K);
    }


    //快速排序，当基准数据是第K个时，停止排序
    public int[][] kClosest1(int[][] points, int K) {
        quickSortK(points,0,points.length-1,K);
        return Arrays.copyOfRange(points,0,K);

    }
    public void quickSortK(int [][] points,int l,int r,int K){
        //t的平方和等于temp
        int [] t = points[l];
        int temp = sumSquare(points,l);

        int left = l;
        int right = r;
        while(left<right){
            while(left<right && sumSquare(points,right) >= temp){
                right--;
            }
            points[left] = points[right];

            while(left<right && sumSquare(points,left) <= temp){
                left++;
            }
            points[right] = points[left];
        }

        points[right] = t;
        if(right > K && l<right-1){
            quickSortK(points,l,right-1,K);
        }else if(right < K && right+1<r){
            quickSortK(points,right+1,r,K);
        }
    }

    //使用一个优先队列（大根堆）实时维护前 KK 个最小的距离平方。
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(K,(a, b)->(b[0]-a[0]));

        for(int i=0;i<K;i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.offer(new int[]{dist,i});
        }

        for(int i=K;i<points.length;i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if(dist<pq.peek()[0]){
                pq.poll();
                pq.offer(new int[]{dist,i});
            }
        }

        int[][] ans = new int[K][2];
        for(int i=0;i<K;i++){
            ans[i]=points[pq.poll()[1]];
        }
        return ans;
    }



    public int sumSquare(int[][] points,int i){
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
}
