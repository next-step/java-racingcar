package step3;

public class Print {
	private static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
	private static final String HOW_MANY_MOVING_COUNT = "시도할 횟수는 몇 회 인가요?";

	void howManyCars() {
		System.out.println(HOW_MANY_CARS);
	}

	void howManyMovingCount() {
		System.out.println(HOW_MANY_MOVING_COUNT);
	}

	void newLine() {
		System.out.println();
	}

	void print(String input) {
		System.out.println(input);
	}
}
