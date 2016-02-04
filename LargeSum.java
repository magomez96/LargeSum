/*
 * By: Alex Massenzio & Matthew Gomez
 * LargeSum.java
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

import java.io.*;
import java.util.Scanner;
public class LargeSum {

	public static void main(String[] args) {
		String fileName = "./input.txt";
		String num = "";
		File file = new File(fileName);
		short[][] numbers = new short[200][50];
		short[] sum = new short[250];
		short i = 0, j = 0, carry = 0, lrgDigit = 0;

		//File I/O
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				num = scan.next();
				//String to 2D array of shorts
				for(int k = num.length() - 1; k >= 0; k--) {
					numbers[i][49 - k] = (short) ((short) num.charAt(j) - '0');
					j++;
				}
				j = 0;
				i++;
				num = "";
			}
			scan.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		//Adding stuff here
		i = 249;
		for(j = 49; j >= 0; j--) {
			for(int k = 0; k < numbers.length; k++) {
				carry += numbers[k][j];
			}
			//System.out.println("Before = " + carry);
			sum[i] = (short)(carry % 10);
			carry = (short)(carry - sum[i]);
			//System.out.println("Digit = " + sum[i]);
			//System.out.println("Carry = " + carry + '\n');
			i--;
		}
		//Finds the greatest number or if sum is 0, whatever comes first.
		for(i = 0; sum[i] == 0 && i < sum.length; i++);
		i--;
		
		while(carry > 0){
			carry /= 10;
			sum[i--] += (short)(carry % 10);
		}
		
		for(i = 0; sum[i] == 0 && i < sum.length; i++);
		lrgDigit = (short)(i);
		
		System.out.print("Full sum: ");
		//Prints the number in the correct format given.
		for(i = lrgDigit; i < sum.length; i++){
			System.out.print(sum[i]);
		}
		
		System.out.print('\n');
		System.out.print("First 10 digits: ");
		for(i = lrgDigit; i < (10 + lrgDigit) && i < sum.length; i++){
			System.out.print(sum[i]);
		}
	}
}
