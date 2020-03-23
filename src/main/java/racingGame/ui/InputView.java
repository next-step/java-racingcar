package racingGame.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String GET_COUNT_OF_CARS_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String GET_TIMES_OF_CARS_GO_MSG = "시도할 회수는 몇 회 인가요?";

	private List<String> racers;
	private int racingTime;

	public void startInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(GET_COUNT_OF_CARS_MSG);
		racers = Arrays.stream(scanner.nextLine().split(","))
				.map(String::trim)
				.collect(Collectors.toList());
		System.out.println(GET_TIMES_OF_CARS_GO_MSG);
		racingTime = scanner.nextInt();
	}

	public List<String> getRacers() {
		return racers;
	}

	public int getRacingTime() {
		return racingTime;
	}
}
