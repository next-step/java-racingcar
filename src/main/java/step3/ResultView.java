package step3;

import java.util.Scanner;

public class ResultView {

	public static void printStatus(int[] result) {
		for(int status : result) {
			System.out.println("-".repeat(status));
		}
		System.out.print("\n");
	}

}
