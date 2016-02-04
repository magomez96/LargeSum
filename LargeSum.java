import java.io.*;
import java.util.Scanner;
public class LargeSum {

	public static void main(String[] args) {
		String fileName = "./input.txt";
		String num = "";
		File file = new File(fileName);
		short[][] numbers = new short[200][50];
		short[] sum = new short[250];
		short i = 0, j = 0, carry = 0;

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
		j = 0;
		for(int k = 0; k < numbers.length; k++) {
			if(sum[i] + numbers[k][j] <= 9) {
				sum[i] += numbers[k][j];
			}
			else {
				//There is a carry
			}
		}
	}
}
