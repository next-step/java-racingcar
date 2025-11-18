package racingcar;

public class OutputView {
	static void printRoundResult(Racing racing) {
		for (String result : racing.play()) {
			System.out.println(result);
		}
	}

	static void printResults(int count, Racing racing) {
		System.out.println("실행 결과");

		for (int i = 0; i < count; i++) {
			printRoundResult(racing);
			System.out.println();
		}
	}

	static void printResultsWinner(int count, Racing racing) {
		System.out.println("실행 결과");

		for (int i = 0; i < count; i++) {
			printRoundResult(racing);
			System.out.println();
		}

		System.out.println(String.join(", ", racing.getWinners()) + "가 최종 우승했습니다.");
	}

	static String getPositionDisplay(Car car) {
		return "-".repeat(car.getPosition());
	}
}
