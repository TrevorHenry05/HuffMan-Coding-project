package project2;

import project2.HuffmanTree.HuffNode;
/**
 * Represents the Priority queue object that extends the Array Heap class.
 * 
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class PriorityQueue extends ArrayHeap {
    
	/**
     * Takes in a Element and a priority and creates the HuffNode and adds it to the Queue.
     * 
     * @param TheElem
     * @param thePriority the number of occurences of the element or the priority of the element.
     */
	public void addElement(char theElem, int thePriority) {
		HuffmanTree x = new HuffmanTree();
		HuffNode myNode = x.new HuffNode(theElem, thePriority);
		
		add(myNode);
	}
	
	/**
     * Removes the minimum node form the root.
     * 
     * @return the minimum node in the priority queue.
     */
	public HuffNode removeNext() {
		return removeMin();
	}
}
