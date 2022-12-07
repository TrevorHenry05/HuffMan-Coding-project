package project2;

import java.util.NoSuchElementException;

import project2.HuffmanTree.HuffNode;

/**
 * Represents the Array Heap Object.
 * 
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class ArrayHeap {

	private HuffNode [] heap = new HuffNode[50];
	public int count = 0;
	
	/**
     * Takes in a HuffNode and adds it to the queue at the last index and calls the helper method to heapify the add.
     * 
     * @param theNode
     */
	public void add(HuffNode theNode) {
		
		if(count == heap.length) {
			expand();
		}
		
		heap[count] = theNode;		
		heapifyAdd(count);
		count++;
	}
	
	/**
     * throws a exception for underflow or Removes the minimum element by swapping the root and the last node and removes 
     * the last node and then calls the helper method to heapify the removal.
     * 
     * @throws NoSuchElementException
     */
	public HuffNode removeMin() {
		if(count == 0) {
			throw new NoSuchElementException("Heap is Empty");
		}
		
		HuffNode temp = heap[0];
		heap[0] = heap[count - 1];
		count--;
		heap[count] = null;
		
		heapifyRemove(0);
		
		return temp;
	}
	
	/**
     * Helper method that reorders the heap when a removeMin has happened.
     * 
     */
	public void heapifyRemove(int theCurr) {
		int smallest = theCurr;
		int left = leftChild(theCurr);
		int right = rightChild(theCurr);
		
		if(left < count && heap[left].compareTo(heap[smallest]) == 1) {
			smallest = left;
		}
		
		if(right < count && heap[right].compareTo(heap[smallest]) == 1) {
			smallest = right;
		}
		
		if(smallest != theCurr) {
			HuffNode swap = heap[theCurr];
			heap[theCurr] = heap[smallest];
			heap[smallest] = swap;
			
			heapifyRemove(smallest);
		}
	}
	
	/**
     * Helper method that reorders the heap when a add has happened.
     * 
     */
	public void heapifyAdd(int theCurr) {
		int parent = parent(theCurr);		
		
		if(parent >= 0 && heap[theCurr].compareTo(heap[parent]) == 1) {
			HuffNode swap = heap[theCurr];
			heap[theCurr] = heap[parent];
			heap[parent] = swap;
			heapifyAdd(parent);
		}
	}
	
	/**
     * Helper method that expands the heap when overflow occurs in the add method.
     * 
     */
	public void expand() {
		HuffNode[] temp = new HuffNode[count + 1];
		temp = (HuffNode[])heap.clone();
		heap = new HuffNode[count + 1];
		heap = (HuffNode[])temp.clone();
    }
	
	/**
     * Helper method that takes in the current index and return the index of the parent.
     * 
     * @param theIndex
     */
	public int parent(int theIndex) {
		return (theIndex - 1) / 2;
	}
	
	/**
     * Helper method that takes in the current index and return the index of the Left Child.
     * 
     * @param theIndex
     */
	public int leftChild(int theIndex) {
		return (2 * theIndex) + 1;
	}
	
	/**
     * Helper method that takes in the current index and return the index of the Right Child.
     * 
     * @param theIndex
     */
	public int rightChild(int theIndex) {
		return (2 * theIndex) + 2;
	}
}
