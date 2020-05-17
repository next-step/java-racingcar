package study3;

import java.util.Scanner;

public class InputView {
	
	public InputView() {	
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		String value = scanner.nextLine();
		
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int number = scanner.nextInt();
	}
}
