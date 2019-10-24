package step1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 사용자 입력을 받는다
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.next();

		// 파싱을 한다
		try {
			Parser parser = new Parser(inputString);
			// TODO: 2019-10-24 계산 과정 추가
		} catch (IllegalArgumentException e) {
			System.out.println("입력한 문자열을 확인해 주세요");
		}
	}

}
