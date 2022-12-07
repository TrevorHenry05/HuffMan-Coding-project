package project2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import project2.HuffmanTree.HuffNode;
/**
 * Driver provides the main methods for taking the file input and testing the Test case from the input file and outputting the formatted 
 * output of each test to the output file.
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class Driver {
	
	/**
     * Main method for Driver.
     * 
     * @param theArgs argument for main method.
	 * @throws IOException 
     */
	public static void main(String[] theArgs) throws IOException {
		String currDirectory = System.getProperty("user.dir");
		BufferedWriter out = new BufferedWriter(new FileWriter( currDirectory + "\\Resources\\Output.txt"));
	
	    Scanner input = new Scanner(new FileInputStream(currDirectory + "\\Resources\\input.txt"));
	    
	    //Test 1
	    HuffmanTree tree1 = new HuffmanTree();
	    String test1 = input.nextLine(), encode1;
	    out.write("[" + test1 + "]");
	    HuffNode node1 = tree1.createHuffmanTree(test1);
	    out.write(tree1.frequencyTable(node1));
	    encode1 = tree1.encode(test1, node1);
	    out.write(formatEncode(encode1));
	    out.write(tree1.decode(encode1, node1));
	    
	    //Test2
	    HuffmanTree tree2 = new HuffmanTree();
	    String test2 = input.nextLine(), encode2;
	    out.write("\n\n[" + test2 + "]");
	    HuffNode node2 = tree2.createHuffmanTree(test2);
	    out.write(tree2.frequencyTable(node2));
	    encode2 = tree2.encode(test2, node2);
	    out.write(formatEncode(encode2));
	    out.write(tree2.decode(encode2, node2));
	    
	    //Test3
	    HuffmanTree tree3 = new HuffmanTree();
	    String test3 = input.nextLine(), encode3;
	    out.write("\n\n[" + test3 + "]");
	    HuffNode node3 = tree3.createHuffmanTree(test3);
	    out.write(tree3.frequencyTable(node3));
	    encode3 = tree3.encode(test3, node3);
	    out.write(formatEncode(encode3));
	    out.write(tree2.decode(encode3, node3));
	    
	    //Test 4
	    HuffmanTree tree4 = new HuffmanTree();
	    String test4 = input.nextLine(), encode4;
	    out.write("\n\n[" + test4 + "]");
	    HuffNode node4 = tree4.createHuffmanTree(test4);
	    out.write(tree4.frequencyTable(node4));
	    encode4 = tree4.encode(test4, node4);
	    out.write(formatEncode(encode4));
	    out.write(tree4.decode(encode4, node4));
	    
	    // Test 5	    
	    HuffmanTree tree5 = new HuffmanTree();
	    String test5 = input.nextLine(), encode5;
	    out.write("\n\n[" + test5 + "]");
	    HuffNode node5 = tree5.createHuffmanTree(test5);
	    out.write(tree5.frequencyTable(node5));
	    encode5 = tree5.encode(test5, node5);
	    out.write(formatEncode(encode5));
	    out.write(tree5.decode(encode5, node5));
	    
	    out.close();
	}
	
	/**
     * Helper for formating the encoded String for output.
     * 
     * @param theString encoded string.
     */
	public static String formatEncode(String theString) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[Encoded Bits: ");
		sb.append(theString);
		sb.append("] [");
		sb.append(theString.length());
		sb.append("]");
		return sb.toString();
	}
	
}
