package study4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public String carInputMessages() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return scanner.nextLine();
	}

	public int trialInputMessages() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return scanner.nextInt();
	}

}
