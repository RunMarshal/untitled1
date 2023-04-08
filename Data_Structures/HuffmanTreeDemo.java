package Data_Structures;

import java.util.*;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
        Node root = CreateHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历");
        }
    }

    public static Node CreateHuffmanTree(int[] arr){

        //1.遍历arr数组
        //2.将数组中每个元素转化为Node类型
        //3.将Node类型的元素放入ArraysList集合
        //4.调用Node类中compareTo方法排序
        List<Node> nodes = new ArrayList<Node>();
        for(int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //1.从小到大排序
            Collections.sort(nodes);
            //2.取出权值最小的两个结点，构建成一个新结点
            Node lchild = nodes.get(0);
            Node rchild = nodes.get(1);
            Node parent = new Node(lchild.value + rchild.value);
            //3.构建新的小二叉树
            parent.lchild = lchild;
            parent.rchild = rchild;
            //4.从ArraysList中删除处理过的结点,增加新的处理的结点
            nodes.remove(lchild);
            nodes.remove(rchild);
            nodes.add(parent);

        }
        //范围根结点
        return nodes.get(0);
    }
}


//为比较大小，一般实现Comparable接口中的compareTo方法
class Node implements Comparable<Node>{
    int value;
    Node lchild;
    Node rchild;

    public Node(int value){ this.value=value;}

    public void preOrder() {
        //调用重写的toString方法，输出当前结点信息
        System.out.println(this);
        if (this.lchild != null) {
            this.lchild.preOrder();
        }

        if (this.rchild != null) {
            this.rchild.preOrder();
        }

    }

    @Override
    public String toString() {
        return  "Node [value=" + this.value + "]";
    }
    //实现该方法
    public int  compareTo(Node o){
        //从小到大排序
        return this.value - o.value;
    }
}