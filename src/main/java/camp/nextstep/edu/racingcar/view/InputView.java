package camp.nextstep.edu.racingcar.view;

import java.util.Scanner;

public class InputView extends View {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int getMakeCarInput() {
		out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	public int getMakeAttempt() {
		out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
