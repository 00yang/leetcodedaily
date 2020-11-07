import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lc1356 {
    public int[] sortByBits(int[] arr) {//自己写的暴力解法,二维列表
        List<List<Integer>> list = new ArrayList<List<Integer>>(14);
        for(int i=0;i<14;i++){
            List<Integer> l = new ArrayList<Integer>();
            list.add(l);
        }

        for(int i=0;i<arr.length;i++){
            int count=0;
            int k=0;
            while(arr[i]>>k >0){
                count+=(arr[i]>>k)&1;
                k++;
            }
            list.get(count).add(arr[i]);


        }
        int j=0;
        for(List li:list){
            Collections.sort(li);
            for(Object x:li){
                arr[j]=Integer.parseInt(x.toString());
                j++;
            }
        }

        return arr;
    }

    public int[] sortByBits1(int[] arr) {//改进
        List<Integer> list = new ArrayList<Integer>();
        for(int x:arr){
            list.add(x);
        }
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer x,Integer y){
                if(countBit(x)==countBit(y)) return x-y;
                return countBit(x)-countBit(y);
            }
        });
        int i=0;
        for(int x:list){
            arr[i]=x;
            i++;
        }
        return arr;
    }
    public int countBit(int x){
        int i=0;
        int count=0;
        while(x>>i>0){
            if((x>>i &1)==1) count++;
            i++;
        }
        return count;
    }

    public int[] sortByBits2(int[] arr) {

        return new int []{1};//明天写
    }


}
