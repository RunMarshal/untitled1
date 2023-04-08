package Data_atguigu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class All_Sort {
    public static void main(String[] args) {
        int[] arr = new int[80000];

        for(int i = 0; i < 80000; ++i) {
            arr[i] = (int)(Math.random() * 8000000.0);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        Sort.RadixSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        Sort.Print(arr);
    }
}

class Sort{
    public static void SelectSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;
            int min = arr[i];

            for(int j = i + 1; j < arr.length; ++j) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void BubbleSort(int[] arr) {
        boolean flag = false;

        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
            flag = false;
        }
    }
    public static void InsertSort(int[] arr) {
        for(int i = 1; i < arr.length; ++i) {
            int insertVal = arr[i];
            int insertIndex;

            for(insertIndex = i - 1; insertIndex >= 0 && insertVal < arr[insertIndex]; --insertIndex) {
                arr[insertIndex + 1] = arr[insertIndex];
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
    public static void QuickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        while(l < r) {
            while(arr[l] < pivot) {
                ++l;
            }
            while(arr[r] > pivot) {
                --r;
            }
            if (l >= r) {
                break;
            }
            int temp= arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                --r;
            }
            if (arr[r] == pivot) {
                ++l;
            }
        }
        if (l == r) {
            ++l;
            --r;
        }
        if (left < r) {
            QuickSort(arr, left, r);
        }
        if (right > l) {
            QuickSort(arr, l, right);
        }
    }
    public static void MergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(arr, left, mid, temp);
            MergeSort(arr, mid + 1, right, temp);
            Merge(arr, left, mid, right, temp);
        }
    }

    public static void Merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while(i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                ++t;
                ++i;
            } else {
                temp[t] = arr[j];
                ++t;
                ++j;
            }
        }
        while(i <= mid) {
            temp[t] = arr[i];
            ++t;
            ++i;
        }
        while(j <= right) {
            temp[t] = arr[j];
            ++t;
            ++j;
        }
        t = 0;
        for(int tempLeft = left; tempLeft <= right; ++tempLeft) {
            arr[tempLeft] = temp[t];
            ++t;
        }
    }
    public static void RadixSort(int[] arr) {
        int max = arr[0];

        int maxLength;
        for(maxLength = 1; maxLength < arr.length; ++maxLength) {
            if (arr[maxLength] > max) {
                max = arr[maxLength];
            }
        }
        maxLength = String.valueOf(max).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        int i = 0;

        for(int n = 1; i < maxLength; n *= 10) {
            int index;
            int k;
            for(index = 0; index < arr.length; ++index) {
                k = arr[index] / n % 10;
                bucket[k][bucketElementCounts[k]] = arr[index];
                int var10002 = bucketElementCounts[k]++;
            }
            index = 0;

            for(k = 0; k < bucketElementCounts.length; ++k) {
                if (bucketElementCounts[k] != 0) {
                    for(int l = 0; l < bucketElementCounts[k]; ++l) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
            ++i;
        }
    }
    public static void ShellSort(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; ++i) {
                for(int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

    }

    public static void ShellSort2(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; ++i) {
                int j = i;
                int temp = arr[i];
                if (arr[i] < arr[i - gap]) {
                    while(j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }

                    arr[j] = temp;
                }
            }
        }

    }

    public static void heapSort(int[] arr) {
        System.out.println("堆排序!!");

        int j;
        for(j = arr.length / 2 - 1; j >= 0; --j) {
            adjustHeap(arr, j, arr.length);
        }

        for(j = arr.length - 1; j > 0; --j) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }
    public static void adjustHeap(int[] arr, int i, int lenght) {
        int temp = arr[i];

        for(int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                ++k;
            }

            if (arr[k] <= temp) {
                break;
            }

            arr[i] = arr[k];
            i = k;
        }

        arr[i] = temp;
    }

    public static void Print(int[] arr){
        for(int item : arr){
            System.out.println(item);
        }
    }

}