package Data_Structures;

public class BiTreeDemo {
    public static void main(String[] args) {
        BiTree binaryTree = new BiTree();
        TreeNode root = new TreeNode(1, "宋江");
        TreeNode node2 = new TreeNode(2, "吴用");
        TreeNode node3 = new TreeNode(3, "卢俊义");
        TreeNode node4 = new TreeNode(4, "林冲");
        TreeNode node5 = new TreeNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node5);
        node3.setLeft(node4);
        binaryTree.setRoot(root);

        System.out.println("删除前,前序遍历");
        binaryTree.PreOrder();
        binaryTree.DelNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.PreOrder();
    }
}

class BiTree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void PreOrder() {
        if (this.root != null) {
            this.root.PreOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void InfixOrder() {
        if (this.root != null) {
            this.root.InfixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void PostOrder() {
        if (this.root != null) {
            this.root.PostOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public TreeNode PreOrderSearch(int no) {
        return this.root != null ? this.root.PreOrderSearch(no) : null;
    }
    public void DelNode(int no){
        if(this.root!=null) {
            //判断root是不是删除结点
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.DelNode(no);
            }
        }else {
            System.out.println("空树，不能删除");
        }
    }
}
class TreeNode{
    private int no;
    private String name;
    //默认为空，不需要构造器初始化
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int no,String name){
        this.no=no;
        this.name=name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "TreeNode [no=" + this.no + ", name=" + this.name + "]";
    }

    public void PreOrder(){
        //不需要判断当前节点是否为空
        System.out.println(this);
        if (this.left != null) {
            this.left.PreOrder();
        }
        if (this.right != null) {
            this.right.PreOrder();
        }
    }
    public void InfixOrder(){
        if (this.left != null) {
            this.left.PreOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.PreOrder();
        }
    }
    public void PostOrder(){
        if (this.left != null) {
            this.left.PreOrder();
        }
        if (this.right != null) {
            this.right.PreOrder();
        }
        System.out.println(this);
    }

    public TreeNode PreOrderSearch(int no){
        System.out.println("进入前序遍历");
        if(this.no==no) return this;
        TreeNode resnode=null;
        //向左递归查找
        if(this.left!=null) resnode=this.left.PreOrderSearch(no);
        if(resnode!=null) return resnode;

        if(this.right!=null) resnode=this.right.PreOrderSearch(no);
        return resnode;
    }

    //递归查找删除结点的父结点
    public void DelNode(int no){
        //如果左子结点不为空，并且为删除结点。删除结点，返回
        if(this.left!=null && this.left.no==no){
            this.left=null;
        }else if(this.right!=null && this.right.no==no){
            this.right=null;return;
        }else {
            if(this.left!=null) this.left.DelNode(no);
            if(this.right!=null) this.right.DelNode(no);
        }
    }
}

























