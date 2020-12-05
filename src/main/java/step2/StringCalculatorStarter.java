package step2;

import java.util.Scanner;

public class StringCalculatorStarter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(StringCalculator.create(scanner.nextLine()).calculate());
	}
}
