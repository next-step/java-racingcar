package carrase;

import java.util.Map;
import java.util.Scanner;

public class CarRacingGameUI {

	public static final String INTRO_MESSAGE_FOR_GET_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
	public static final String INTRO_MESSAGE_FOR_GET_GAME_COUNT = "시도할 회수는 몇 회 인가요?";
	public static final String INTRO_MESSAGE_FOR_GAME_RESULT = "실행 결과";

	public int getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public void printResult(Map<String, Integer> result) {
		result.forEach((name, mileage) -> {
			System.out.print(name + " : ");
			printCarMileage(mileage);
		});
		System.out.println();
	}

	private void printCarMileage(int distance) {
		for(int i = 0; i < distance; i ++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printMessageOfGameResult() { System.out.println(INTRO_MESSAGE_FOR_GAME_RESULT); }

	public void printQuestionOfCarCount() { System.out.println(INTRO_MESSAGE_FOR_GET_CAR_COUNT); }

	public void printQuestionOfGameCount() { System.out.println(INTRO_MESSAGE_FOR_GET_GAME_COUNT); }
}
