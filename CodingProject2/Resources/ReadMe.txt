1. Height of tree = log2(n) (log base2 of n)
   TimeComplexity:
       encoded(): O(nlog(n))
       decode():  O(n)  n = the length of the encoded string
2. Advantages is that is saves in storage since the created codes from tree for each character is at max the height of the tree and not represented by a 8 bit  binary code for each, this in turn creates shorter binary codes for encoding symbols. Disadvantages
   I found is that its kinda slow since you need to create the Huffman tree and then encode the string. Also you need the Huffman Tree to decode the encoded string. Lastly, soemthing I read online is that its only good for encoding text and program files and not good for
   encoding digital images.

   For FIFO queue instead of a priority queue would be better because in some cases for the priority queue you can get trees that arent really unbalanced and can be very heavy to the left or right which in turn can cause some characters to have really long code lengths which will cause the compression ratio to
   deteriorate. In a FIFO queue the tree tends to come out more balanced and the codes length will be around the height of the tree for each chracter will have a imporved compression rate for every string.

3. This project took me about 6 Hours. Some of the challeneges I faced was getting the Huffman Tree to be created from the string and it took a lot of trial and error changing things trying new stuff to get it to work. Another challenge I faced was creating the frequency table and getting the codes from the tree 
   and storing them for use later. I overcame this by using a looking up and remembering how to use a hashmap to store the code,and frequencies as a value and the character as key. This helped me in the encoding since I could just use this hashmap to look up the code using the chracter in the string and then adding
   it to the encoded string.