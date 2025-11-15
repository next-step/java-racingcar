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
}
