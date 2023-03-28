package Data_Structures;

public class ArrayBiTreeDemo {
    public static void main(String[] args) {
            int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
            ArrBiTree arrBinaryTree = new ArrBiTree(arr);
            arrBinaryTree.PreOrder(0);
    }
}

class ArrBiTree{
    private int[] arr;

    public ArrBiTree(int[] arr){
        this.arr = arr;
    }

    public void PreOrder(int index){
        if (this.arr == null || this.arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        System.out.println(this.arr[index]);

        if (index * 2 + 1 < this.arr.length) {
            this.PreOrder(2 * index + 1);
        }

        if (index * 2 + 2 < this.arr.length) {
            this.PreOrder(2 * index + 2);
        }
    }
}
