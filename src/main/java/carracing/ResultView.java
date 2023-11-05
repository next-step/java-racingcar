package carracing;

import carracing.car.Car;

public class ResultView {
	public static void printResultPhrase() {
		System.out.println("실행 결과");
	}

	public static void printMovingResult(Car car) {
		String result = "-".repeat(Math.max(0, car.movingDistance()));
		System.out.println(car.name() + " : " + result);
	}

	public static void empty() {
		System.out.println("");
	}
}
