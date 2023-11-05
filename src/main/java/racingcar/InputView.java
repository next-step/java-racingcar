package racingcar;

import java.util.Scanner;

public class InputView {
	private Integer totalCarNum;
	private Integer totalRound;

	public InputView() {
		init();
	}

	public void init()  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		this.totalCarNum = scanner.nextInt();

		System.out.println("시도할 횟수는 몇 회 인가요?");
		this.totalRound = scanner.nextInt();
	}

	public Integer getTotalCarNum() {
		return totalCarNum;
	}

	public Integer getTotalRound() {
		return totalRound;
	}
}
