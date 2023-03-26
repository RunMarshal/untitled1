package Data_atguigu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class All_Search {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,4,5,6,7};
        System.out.println(Search.InsertValue_Search(arr,0,arr.length-1,4));
    }
}

class Search{
    public static int Binary_Search(int[] arr,int left,int right,int value){
        if(left>right){
            System.out.println("没有找到值为："+value+"的元素");
            return -1;
        }else {
            int mid=left+(right-left)/2;
            if(value >arr[mid]){
                return Binary_Search(arr,mid+1,right,value);
            } else if (value < arr[mid]) {
                return Binary_Search(arr,left,mid-1,value);
            }else {
                return mid;
            }
        }
    }

    public static List<Integer> Binary_Search2(int[]arr,int left,int right,int value){
        if(left>right){
            System.out.println("没有找到值为："+value+"的元素");
            return new ArrayList<>();
        }else{
            int mid=left+(right-left)/2;
            if(value>arr[mid]){
                return Binary_Search2(arr,mid+1,right,value);
            } else if (value<arr[mid]) {
                return Binary_Search2(arr,left,mid-1,value);
            } else {
                int temp=mid;
                List<Integer> arrayList=new ArrayList<>();

                for(temp=mid-1;temp>=0 && arr[temp]==value;temp--){
                    arrayList.add(temp);
                }
                arrayList.add(mid);
                for (temp=mid+1;temp<arr.length-1 && arr[temp]==value;temp++){
                    arrayList.add(temp);
                }
                return arrayList;
            }
        }
    }

    public static int InsertValue_Search(int[] arr,int left,int right,int value){
        if (left<=right && value>=arr[0] && value <=arr[arr.length-1]){
            int mid=left+(right - left) * (value - arr[left]) / (arr[right] - arr[left]);
            if(value>arr[mid]){
                return InsertValue_Search(arr,mid+1,right,value);
            }else {
                return value < arr[mid] ? InsertValue_Search(arr, left, mid - 1, value) : mid;
            }
        } else {
            return -1;
        }
    }

    public static int[]fibonacci(){
        int[] f=new int[20];
        f[0]=1;f[1]=1;

        for(int i=2;i<20;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    public static int Fibonacci_Search(int[] arr,int value){
        int left=0,right=arr.length-1;
        int k=0,mid=0;
        int[] f=fibonacci();

        while(right>f[k]-1){
            k++;
        }
        int[] temp= Arrays.copyOf(arr,f[k]);
        for(int i=right+1;i<temp.length;i++) temp[i]=temp[right];
        while (left<=right){
            mid=left+f[k-1]-1;
            if(value <temp[mid]){
                right=mid-1;
                k--;
            }else if(value >temp[mid]){
                left=mid+1;
                k-=2;
            }else{
                if(mid<=right) return mid;
                else return right;
            }
        }
        return -1;
    }
}










