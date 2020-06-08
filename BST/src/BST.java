import java.util.Stack;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName BST.java
 * @Description 二分搜索树
 * @createTime 2020年06月07日 20:10:00
 */
public class BST<E extends Comparable<E>> {

    // 根节点
    private Node root;

    // 容量
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @Author Jiangyf
     * @Description 向二分搜索树中添加新的元素e
     * @Date 2020/6/8
     * @Param [e]
     * @return void
     **/
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        // 返回插入新节点后二分搜索树的根节点
        if (node == null) {
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            // 若插入元素小于当前节点的元素值，将插入元素插入当前节点的左子树
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // 若插入元素大于当前节点的元素值，将插入元素插入当前节点的右子树
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * @Author Jiangyf
     * @Description 查找二分搜索树中是否包含元素e
     * @Date 2020/6/8
     * @Param [e]
     * @return boolean
     **/
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * @Author Jiangyf
     * @Description 前序遍历
     * @Date 2020/6/8
     * @Param []
     * @return void
     **/
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            // 根左右
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrderNR() {
        // 利用栈结构进行操作
        Stack<Node> stack = new Stack<>();
        // 先将根节点压入栈
        stack.push(root);
        // 遍历栈
        while (!stack.empty()) {
            // 获取当前栈顶元素
            Node curNode = stack.pop();
            // 前序遍历（根左右）
            System.out.println(curNode.e);
            // 依次处理当前栈顶节点的左右子树（注意栈的特性：后进先出，因此先将右子树节点压入栈）
            if (null != curNode.right) {
                stack.push(curNode.right);
            }
            if (null != curNode.left) {
                stack.push(curNode.left);
            }
        }
    }

    /**
     * @Author Jiangyf
     * @Description 中序遍历
     * @Date 2020/6/8
     * @Param []
     * @return void
     **/
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            // 左根右
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    public void inOrderNR() {
        // 利用栈结构进行操作
        Stack<Node> stack = new Stack<>();
        // 获取根节点（当前节点作为指针）
        Node curNode = root;
        while (!stack.empty() || null != curNode) {
            // 若当前节点不为null，压入栈，并将指针指向其左节点，循环此操作
            while (null != curNode) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            // 全部压入栈之后，弹出栈顶元素
            Node topNode = stack.pop();
            System.out.println(topNode.e);
            // 节点指针指向弹出元素的右节点
            curNode = topNode.right;
        }
    }

    /**
     * @Author Jiangyf
     * @Description 后序遍历
     * @Date 2020/6/8
     * @Param []
     * @return void
     **/
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            // 左右根
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }

    public void postOrderNR() {
        // 利用栈结构进行操作
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node curNode = stack.pop();
            if (null != curNode.right) {
                stack.push(curNode.right);

            }

            stack.push(curNode.left);

        }
    }


    /**
     * @Author Jiangyf
     * @Description 树节点 - 内部类
     * @Date 2020/6/7
     * @Param
     * @return
     **/
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) {
        int[] nodes = {7, 3, 4, 2, 8, 1};
        BST<Integer> bst = new BST<>();
        for (int node : nodes) {
            bst.add(node);
        }
        bst.preOrder();
        System.out.println("--------------");
        bst.preOrderNR();
        System.out.println("--------------");
        bst.inOrder();
        System.out.println("--------------");
        bst.inOrderNR();
        System.out.println("--------------");
        bst.postOrder();
    }

}
