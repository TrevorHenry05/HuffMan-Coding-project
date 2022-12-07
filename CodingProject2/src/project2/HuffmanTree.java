package project2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Represents the Huffman Tree class and methods for driver program.
 * 
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class HuffmanTree {
    /**
     * Priority queue for the Huffman Tree  creation
     */
	public PriorityQueue myQueue = new PriorityQueue();
    
	/**
	* Inner Class for the HuffNode of the Queue.
	*/
	public class HuffNode {

		public char myChar;
		public int myFrequency;
		public HuffNode myLeft = null, myRight = null;
		
		/**
		 * Takes in a Element and a Frequency and creates a HuffNode.
		 * @param theElem
		 * @param theFrequency
		 */
		public HuffNode(char theElem, int theFrequency) {
			this.myChar = theElem;
			this.myFrequency = theFrequency;
		}
		
		/**
		 * Takes in a HuffNode and compares it to the passed Node
		 * 
		 * @param theNode
		 * @return whether the this HuffNode frequency is less then or equal to the HuffNode passed as a param.
		 */
		public int compareTo(HuffNode theNode) {
			if(this.myFrequency < theNode.myFrequency) {
				return 1;
			}
			return -1;
		}
		
	}

	/**
	 * Takes in a string and counts occurrences of the character in the string and creates a HuffNode for each and adds it to a 
	 * priority queue. Then takes that priority queue and creates a Huffman Tree from the nodes of the priority queue and returns
	 * the root of the tree.
	 * 
	 * @param theString
	 * @return the root of the Tree
	 */
	public HuffNode createHuffmanTree(String theString) {
		StringBuilder sb = new StringBuilder();
		
		char[] arr1 = theString.toCharArray();
		Arrays.sort(arr1);
		String str1 = new String(arr1);
		char currElem = str1.charAt(0);
		int count = 0;
		
		for(int i = 0; i < str1.length(); i++) {
			if(currElem == str1.charAt(i)) {
				count++;
			} else {
				myQueue.addElement(currElem, count);
				sb.append(count);
				sb.append(currElem);
				currElem = str1.charAt(i);
				count = 1;
			}
		}
		myQueue.addElement(currElem, count);
		
		HuffNode temp1, temp2, newNode;
		
		while(myQueue.count > 1) {
			temp1 = myQueue.removeNext();
			temp2 = myQueue.removeNext();
			newNode = new HuffNode(' ', temp1.myFrequency + temp2.myFrequency);
			newNode.myLeft = temp1;
			newNode.myRight = temp2;
			myQueue.add(newNode);
		}
		
		return myQueue.removeNext();
	}
	
	/**
	 * Takes in the root of the HuffMan tree and calls the method that creates a HashMap of the Frequency table and
	 * iterates over the returned HashMap key set to create the formated string version of the Frequency table and returns it.
	 * 
	 * @param theNode
	 * @return the formated string version of the frequency table
	 */
	public String frequencyTable(HuffNode theNode) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character,String[]> freqTable = createFrequencyTable(theNode);
		
		sb.append("\n======================================\n");
		sb.append("Char      Frequency      Code         \n");
		sb.append("--------------------------------------\n");
		
		for(Character key : freqTable.keySet()) {
			sb.append(key);
			sb.append("         ");
			String[] arr = freqTable.get(key);
			sb.append(arr[0]);
			sb.append("              ");
			sb.append(arr[1]);
			sb.append("\n");
		}
		
		sb.append("======================================");
		
		return sb.toString();
	}
	
	/**
	 * Takes in the root of the Huffman Tree and calls the helper method that creates Hash map and Then returns the resulting
	 * HashMap representation of the frequency table.
	 * 
	 * @param theNode
	 * @return Hash map representation of the frequency table.
	 */
	public HashMap<Character, String[]> createFrequencyTable(HuffNode theNode) {
		HashMap<Character, String[]> freqTable = new HashMap<>();
		String code = "";
		return createFrequencyTable(theNode, freqTable, code);
	}
	
	/**
	 * Takes in HuffNode, Hash map of the current frequency table, and a string for the code of each element. Recursively goes through the tree
	 * to determine the codes for each element and adds the element as a key for the Hash map with an array as the value containing the frequency and the code for the element.
	 * @param theNode
	 * @param theTable
	 * @param theCode
	 * @return the Hash map of the frequency table
	 */
	private HashMap<Character, String[]> createFrequencyTable(HuffNode theNode, HashMap<Character, String[]> theTable, String theCode) {
		HashMap<Character, String[]> freqTable = theTable;
		if(theNode.myLeft == null && theNode.myRight == null) {			
			String[] arr = new String[2];
			String str = theNode.myFrequency + "";
			arr[0] = str;
			arr[1] = theCode;
			freqTable.put(theNode.myChar, arr);
		} else {
			freqTable = createFrequencyTable(theNode.myLeft, freqTable, theCode + "0");
			freqTable = createFrequencyTable(theNode.myRight, freqTable, theCode + "1");
		}
		
		return freqTable;
	}
	
	
	/**
	 * Takes in the theString and the root of the Huffman Tree for the string. Calls the helper method to create the hashmap of the frequency table
	 * that contains the codes we need to encode the string, then encodes it and returns the encoded string.
	 * 
	 * @param theString
	 * @param theNode
	 * @return encoded string
	 */
	public String encode(String theString, HuffNode theNode) {
		StringBuilder sb1 = new StringBuilder();
		HashMap<Character,String[]> freqTable = createFrequencyTable(theNode);

		for(int i = 0; i < theString.length(); i++) {
			String[] arr = freqTable.get(theString.charAt(i));
			sb1.append(arr[1]);
		}		
		return sb1.toString();
	}
	
	
    /**
     * Take sin the encoded string and the Node of the Huffman tree for the original String. Iterates over the encoded string
     * and goes through the tree creating the original string as it goes through it and then return the formated decoded string and compression ratio after its done.
     * 
     * @param theString
     * @param theNode
     * @return formatted version of the decoded string and compression ratio
     */
	public String decode(String theString, HuffNode theNode) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		HuffNode curr = theNode;
		int decodeLength, encodelength = theString.length();
		
		for(int i = 0; i < theString.length(); i++) {			
			if(theString.charAt(i) == '0') {
				curr = curr.myLeft;
			} else {
				curr = curr.myRight;
			}
			
			if(curr.myLeft == null && curr.myRight == null) {
				sb1.append(curr.myChar);
				curr = theNode;
			}
		}
		
		decodeLength = sb1.toString().length() * 8;

		sb.append("\n[Decoded String: ");
		sb.append(sb1.toString());
		sb.append("] [");
		sb.append(decodeLength);
		sb.append("] \n[Compression Ratio: ");
		sb.append((double) decodeLength / (double) encodelength);
		sb.append("]");
		
		return sb.toString();
	}

}
