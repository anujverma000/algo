/**
 * @author anujverma000 on 08/20/2015
 * 
 */
package com.base64;

public class Base64 {
	
	/**
	 * Encodes a string to Base64 encoding
	 * 
	 * @param input
	 * @return
	 */
	public static String encodeBase64(String input){
		String out = "";
		String allChars = "=BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		char array [] = allChars.toCharArray();
		int bigArray [] = new int[8 * input.length()];
		int offset = 0;
		for (int i = 0; i < input.length(); i++) {
			int a[] = binaryArray(input.charAt(i));
			bigArray = copyInto(bigArray, a, offset);
			offset += a.length; 
		}
		
		bigArray = padArray(bigArray);
		offset = 0;
		for (int i = 0; i < bigArray.length ; i = i + 6){
			int endoingArray [] = new int[6];
			for(int x = 0 ; x < 6 ;x ++){
				endoingArray[x] = bigArray[i+x];
			}
			out += array[getEncodedCharFromBinaryArray(endoingArray)];
		}
		return out;
	}
	
	/**
	 * Convert an integer 'n' to its binary form of 8 bits
	 * 
	 * @param n
	 * @return
	 */
	private static int [] binaryArray(int n){
		int a[] = new int[8];
		for(int i = a.length -1 ; i >= 0 ; i--){
			a[i] = n%2;
			n = n/2;
		}
		return a;
	}
	
	/**
	 * Get encoded int form 6 bit array
	 * @param a
	 * @return
	 */
	private static int getEncodedCharFromBinaryArray(int a[]){
		int n = 0;
		for(int i = 0; i <a.length; i++){
			n += a[i] * power(2, a.length -1 -i);
		}
		return n;
	}
	
	/**
	 * Copy array 'b' into 'a' form the offset point in 'a'
	 * @param a
	 * @param b
	 * @param offset
	 * @return
	 */
	private static int [] copyInto(int a[], int b[], int offset){
		int j=0;
		for(int i = offset ; i <  offset + b.length ; i++){
			a[i] = b[j];
			j++;
		}
		return a;
	}
	
	/**
	 * Pads extra 0's at the end
	 * 
	 * @param a
	 */
	private static int [] padArray(int []a){
		int zeroArray [] = {0, 0, 0, 0, 0, 0, 0};
		if( a.length % 24 != 0 ){
			int zeroIndex = a.length;
			int temp[] = new int[a.length + 8];
			a = copyInto(temp, a, 0);
			a = padArray(copyInto(a, zeroArray, zeroIndex));
		}
		return a;
	}
	
	private static int power(int n, int p){
		int val = 1;
		for(int i=0; i< p; i++){
			val = val*n;
		}
		return val;
	}
	
}
