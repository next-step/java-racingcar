package carrase;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarRacingGameUI {

	public static final String INTRO_MESSAGE_FOR_GET_GAME_COUNT = "시도할 회수는 몇 회 인가요?";
	public static final String INTRO_MESSAGE_FOR_GAME_RESULT = "실행 결과";
	public static final String INTRO_MESSAGE_FOR_GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

	public int getGameCount() {
		Scanner sc =  new Scanner(System.in);
		return sc.nextInt();
	}

	public List<String> getCarNames() {
		Scanner sc =  new Scanner(System.in);
		String inputName = sc.nextLine();
		String[] names = inputName.split(",");
		return Arrays.asList(names);
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

	public void printWinner(List<String> carGameWinner) {
		System.out.print(carGameWinner.get(0));
		carGameWinner.remove(0);
		carGameWinner.forEach((winner) -> System.out.print(", " + winner));
		System.out.println("가 최종 우승했습니다.");
	}

	public void printMessageOfGameResult() { System.out.println(INTRO_MESSAGE_FOR_GAME_RESULT); }

	public void printQuestionOfGameCount() { System.out.println(INTRO_MESSAGE_FOR_GET_GAME_COUNT); }

	public void printQuestionOfCarNames() { System.out.println(INTRO_MESSAGE_FOR_GET_CAR_NAMES); }
}
