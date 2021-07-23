package calculator;

import java.util.Scanner;

public class CalculcatorUI {
	public static void printIntro() {
		System.out.println("계산기에 수식을 입력해주세요.");
	}

	public static String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static void printResult(int result) {
		System.out.println("계산 결과값 : " + result);
	}
}
