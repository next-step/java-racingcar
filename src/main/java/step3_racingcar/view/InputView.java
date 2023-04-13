package step3_racingcar.view;

import java.util.Random;
import java.util.Scanner;

import step3_racingcar.GameRule;

public class InputView {
	private final static String inputCar = "자동차 대수는 몇 대 인가요?";
	private final static String inputAttempt = "시도할 회수는 몇 회 인가요?";
	private static final Scanner scanner = new Scanner(System.in);
	private static final Random random = new Random();
	private static InputView inputView;
	private final GameRule gameRule = GameRule.getInstance();
	private int index_car;
	private int index_attempt;

	public InputView() {
	}

	public static InputView getInstance() {
		if (inputView == null) {
			inputView = new InputView();
		}

		return inputView;
	}

	public void racingSetting() {
		System.out.println(inputCar);
		this.index_car = gameRule.isAcceptableValue(scanner.nextLine());

		System.out.println(inputAttempt);
		this.index_attempt = gameRule.isAcceptableValue(scanner.nextLine());

		return
	}
}
