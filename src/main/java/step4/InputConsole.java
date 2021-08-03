package step4;

import java.util.Scanner;

public class InputConsole {

	private String[] carNames;
	private int executionCount;
	private Scanner scanner;

	public InputConsole() {
		this.scanner = new Scanner(System.in);
	}

	public void setValues() {
		setCarNames();
		setExecutionCount();
	}

	private void setCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String carNamesContainedByComma = scanner.next();
		carNames = carNamesContainedByComma.split(",");
	}

	private void setExecutionCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		executionCount = scanner.nextInt();
	}

	public String[] getCarNames() {
		return this.carNames;
	}
	public int getExecutionCount() { return this.executionCount; }
}
