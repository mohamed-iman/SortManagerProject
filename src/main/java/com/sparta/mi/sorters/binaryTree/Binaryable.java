package com.sparta.mi.sorters.binaryTree;

import com.sparta.mi.exceptions.ChildNotFoundException;

public interface Binaryable {
    int getRootElement();
    int getNumberOfElements(Node rootNode);

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();
    int[] getSortedTreeDesc();



}
