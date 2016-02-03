import java.io.*;
import java.util.Scanner;
public class LargeSum {

	public static void main(String[] args) {
		String fileName = "./input.txt";
		String num = "";
		File file = new File(fileName);
		short[][] numbers = new short[200][50];
		short i = 0, j = 0;
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				num = scan.next();
				for(int k = num.length() - 1; k >= 0; k--) {
					numbers[i][49 - k] = (short) ((short) num.charAt(j) - '0');
					j++;
				}
				j = 0;
				for(int k = 0; k < numbers[i].length; k++) {
					System.out.print(numbers[i][k]);
				}
				System.out.print("\n");
				i++;
				num = "";
			}
			scan.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
