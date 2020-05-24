package study3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int carInputMessages() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	public int trialInputMessages() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return scanner.nextInt();
	}

}
