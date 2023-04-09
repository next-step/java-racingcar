import java.util.Scanner;

public class ResultView {


	static void printStatus(int[] result) {
		for(int status : result) {
			System.out.println("-".repeat(status));
		}
		System.out.print("\n");
	}

}
