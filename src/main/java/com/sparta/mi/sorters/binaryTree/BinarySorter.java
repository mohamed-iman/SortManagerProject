package com.sparta.mi.sorters.binaryTree;

import com.sparta.mi.exceptions.ChildNotFoundException;
import com.sparta.mi.sorters.Sortable;

import java.util.Arrays;

public class BinarySorter implements Binaryable, Sortable {
    private Node rootNode;
    private int [] array;
    private int i;

    public BinarySorter() {
    }

    private void addNodeToTree(Node node, int element) {
        if (element < node.getValue()){
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(),element);
            }
        } else if(element >= node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    private int nodeNumber(Node rootNode){
        if (rootNode == null){
            return 0;
        }
        return nodeNumber(rootNode.getLeftChild()) + nodeNumber(rootNode.getRightChild())+1;
    }
    @Override
    public int getNumberOfElements (Node rootNode){
        return nodeNumber(rootNode);
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    private void addNodesToTree(int[] array) {
        int index = 1;
        Node node = rootNode;
        for(int i = 1; i < array.length; i++) {
            NewNodeSet:
            do {
                if (array[i] < node.getValue()) {
                    if (node.isLeftChildEmpty()) {
                        node.setLeftChild(new Node(array[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                    }
                } else if (array[i] > node.getValue()) {
                    if (node.isRightChildEmpty()) {
                        node.setRightChild(new Node(array[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getRightChild();
                    }
                } else if(array[i] == node.getValue()) {
                    if (node.isLeftChildEmpty()) {
                        node.setLeftChild(new Node(array[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                    }
                }
            } while(index < array.length);
        }
    }
    @Override
    public void addElements(final int[] array) {
        addNodesToTree(array);
    }

    public boolean findElement (int element){
        Node node = findNode(element);
        if (node != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node.getLeftChild() == null) {
            throw new ChildNotFoundException();
        }
        return node.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node.getRightChild() == null) {
            throw new ChildNotFoundException();
        }
        return node.getRightChild().getValue();
    }

    public int[] makeSortedTreeAsc(int[] array, Node node) {
        if (!node.isLeftChildEmpty()) {
            makeSortedTreeAsc(array, node.getLeftChild());
        }
        array[i] = node.getValue();
        i += 1;
        if (!node.isRightChildEmpty()) {
            makeSortedTreeAsc(array, node.getRightChild());
        }
        return array;
    }

    public int[] makeSortedTreeDesc(int[] sortedArray, Node node) {
        if (!node.isRightChildEmpty()) {
            makeSortedTreeAsc(sortedArray, node.getRightChild());
        }
        sortedArray[i] = node.getValue();
        i += 1;
        if (!node.isLeftChildEmpty()) {
            makeSortedTreeDesc(sortedArray, node.getLeftChild());
        }
        return sortedArray;
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArrayToFill = new int[array.length];
        return makeSortedTreeAsc(sortedArrayToFill, rootNode);
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArrayToFill = new int[array.length];
        return makeSortedTreeDesc(sortedArrayToFill, rootNode);
    }

    private Node findNode(int element){
        Node node = rootNode;
        while (node !=null) {
            if (element == node.getValue()){
                return node;
            }
            if (element < node.getValue()){
                node = node.getLeftChild();
            } else if (element > node.getValue()){
                node = node.getRightChild();
            }
        }
        return null;
    }

    @Override
    public String getSortedArray(int[] array) {
        rootNode = new Node(array[0]);
        this.array = array;
        addElements(array);
        return Arrays.toString(getSortedTreeAsc());
    }
}
