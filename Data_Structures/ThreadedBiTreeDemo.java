package Data_Structures;

public class ThreadedBiTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode);
        System.out.println("10号结点的后继结点是=" + rightNode);
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList();
    }
}

class ThreadedBinaryTree {
    private HeroNode root;
    //为实现线索化，添加pre指向前驱结点
    private HeroNode pre = null;

    ThreadedBinaryTree() {
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 遍历线索化二叉树
    public void threadedList() {
        for(HeroNode node = this.root; node != null; node = node.getRight()) {
            while(node.getLeftType() == 0) {
                //直到找到lefttype值为1的结点
                node = node.getLeft();
            }

            System.out.println(node);

            while(node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
        }

    }
    //重载，不用传参
    public void threadedNodes() {
        this.threadedNodes(this.root);
    }

    public void threadedNodes(HeroNode node) {
        if (node != null) {
            // 先线索化左子树
            this.threadedNodes(node.getLeft());
            // 处理当前结点的前驱结点
            if (node.getLeft() == null) {
                node.setLeft(this.pre);
                node.setLeftType(1);
            }
        // 处理当前结点的后继结点
            if (this.pre != null && this.pre.getRight() == null) {
                this.pre.setRight(node);
                this.pre.setRightType(1);
            }
        // 移动pre指针，指向刚处理好的结点
            this.pre = node;
            // 线索化右子树
            this.threadedNodes(node.getRight());
        }
    }

    public void delNode(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }

    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    public HeroNode preOrderSearch(int no) {
        return this.root != null ? this.root.preOrderSearch(no) : null;
    }

    public HeroNode infixOrderSearch(int no) {
        return this.root != null ? this.root.infixOrderSearch(no) : null;
    }

    public HeroNode postOrderSearch(int no) {
        return this.root != null ? this.root.postOrderSearch(no) : null;
    }
}
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //为0表示是左子树 1表示是前驱结点
    private int leftType;
    //为0表示是右子树 1表示是后继结点
    private int rightType;

    public int getLeftType() {
        return this.leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return this.rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return this.left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return this.right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public String toString() {
        return "HeroNode [no=" + this.no + ", name=" + this.name + "]";
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
        } else if (this.right != null && this.right.no == no) {
            this.right = null;
        } else {
            if (this.left != null) {
                this.left.delNode(no);
            }

            if (this.right != null) {
                this.right.delNode(no);
            }

        }
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }

    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        if (this.no == no) {
            return this;
        } else {
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrderSearch(no);
            }

            if (resNode != null) {
                return resNode;
            } else {
                if (this.right != null) {
                    resNode = this.right.preOrderSearch(no);
                }

                return resNode;
            }
        }
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        } else {
            System.out.println("进入中序查找");
            if (this.no == no) {
                return this;
            } else {
                if (this.right != null) {
                    resNode = this.right.infixOrderSearch(no);
                }
                return resNode;
            }
        }
    }
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        } else {
            if (this.right != null) {
                resNode = this.right.postOrderSearch(no);
            }

            if (resNode != null) {
                return resNode;
            } else {
                System.out.println("进入后序查找");
                return this.no == no ? this : resNode;
            }
        }
    }
}