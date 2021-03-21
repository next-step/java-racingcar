package im.juniq.racingcar.view;

import java.util.Scanner;

public class InputView {
	private static final String SEPARATOR = ",";
	private String[] carNames;
	private int numberOfTries;

	public void scan() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.next();
		carNames = inputString.split(SEPARATOR);
		System.out.println("시도할 회수는 몇 회 인가요?");
		numberOfTries = scanner.nextInt();
		System.out.println();
		System.out.println("실행결과");
	}

	public int numberOfTries() {
		return numberOfTries;
	}

	public String[] carNames() {
		return carNames;
	}
}
