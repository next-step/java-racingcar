package carracing;

import carracing.car.Car;

import java.util.List;

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

	public static void printWinners(List<Car> winners) {
		StringBuilder sb = new StringBuilder();
		for (Car winner : winners) {
			sb.append(winner.name()).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append("가 최종 우승했습니다.");
		System.out.println(sb.toString());
	}
}
