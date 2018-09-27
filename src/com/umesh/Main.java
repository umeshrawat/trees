package com.umesh;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Node rootNode = main.createTree();
        main.dft(rootNode);
        //main.dftIteratively(rootNode);
        //main.bft(rootNode); bft iteratively uses a queue hence, using a call stack to traverse this would be very challenging if not impossible (need to research this)
        //main.bftIteratively(rootNode);
        //inorderTraversal(rootNode);

    }

    private void bft(Node rootNode) {
        System.out.println(rootNode.val);
        if(rootNode.left != null)
            System.out.println(rootNode.left.val);
        if(rootNode.right != null)
            System.out.println(rootNode.right.val);
        if (rootNode == null)
            return;
        bft(rootNode.left.left);
        bft(rootNode.right.right);

    }

    private void bftIteratively(Node rootNode) {
        Queue queue = new ArrayDeque();
        queue.add(rootNode);
        while(queue.size() != 0) {
            Node currentNode = (Node) queue.poll();
            System.out.println(currentNode.val);
            if(currentNode.left != null)
                queue.add(currentNode.left);
            if(currentNode.right != null)
                queue.add(currentNode.right);
        }
    }

    private static void inorderTraversal(Node rootNode) {
        if (rootNode == null)
            return;
        inorderTraversal(rootNode.left);
        System.out.println(rootNode.val);
        inorderTraversal(rootNode.right);

    }

    private void dftIteratively(Node rootNode) {
        Deque<Node> stack = new ArrayDeque<>();

            stack.push(rootNode);
            while (stack.size() != 0) {
                Node retreivedNode = stack.pop();
                System.out.println(retreivedNode.val);
                if(retreivedNode.right != null) {
                    stack.push(retreivedNode.right);
                }
                if(retreivedNode.left != null) {
                    stack.push(retreivedNode.left);
                }
            }

    }

    private Node createTree() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2,null, null);
        Node node3 = new Node(3,null, null);
        node1.left = node2;
        node1.right = node3;
        Node node4 = new Node(4,null, null);
        node2.left = node4;
        Node node5 = new Node(5,null, null);
        node2.right = node5;
        Node node6 = new Node(6,null, null);
        node3.left = node6;
        Node node7 = new Node(7,null, null);
        node3.right = node7;
        return  node1;
    }

    private Node insertNode(Node node, int i) {
        Node newNode = new Node(i, null, null);
        if ((i < node.val))
            node.left = newNode;
        else
            node.right = newNode;
        return newNode;
    }

    static void dft(Node root) {
        if (root == null)
            return;
        System.out.println(root.val);
        dft(root.left);
        dft(root.right);
    }
}
