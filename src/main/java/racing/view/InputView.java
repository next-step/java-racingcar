package racing.view;

import java.util.Scanner;

public class InputView {
	private String inputName;
	private int playCount;

	Scanner scanner = new Scanner(System.in);

	public InputView() {
	}

	public String getInputName() {
		return inputName;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void inputCarsName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String inputName = scanner.next();
		this.inputName = inputName;
		System.out.println(inputName);
	}

	public void inputPlayCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		int playCount = scanner.nextInt();
		System.out.println(playCount);
		this.playCount = playCount;
	}
}
