package camp.nextstep.edu.racingcar.view;

import java.util.Scanner;

public class InputView extends View {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int getMakeAttempt() {
		out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}

	public String getMakeUserCarInput() {
		out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return scanner.next();
	}
}
