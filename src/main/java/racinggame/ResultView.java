package racinggame;

import java.util.List;
import java.util.StringJoiner;
import racinggame.domain.Car;

public class ResultView {

	public static void printHeader() {
		System.out.println("실행 결과");
	}

	public static void print(List<Car> cars) {
		for(Car car : cars) {
			System.out.println(makeOutputPosition(car));
		}
		System.out.println();
	}

	private static String makeOutputPosition(Car car) {
		StringBuilder outputPosition = new StringBuilder(car.getName()).append(" : ");
		for(int i = 0; i < car.getCurrentPosition(); i++) {
			outputPosition.append("-");
		}
		return outputPosition.toString();
	}

	public static void printRacingResult(RacingGameResult racingGameResult) {
		StringJoiner names = new StringJoiner(", ");
		List<Car> winners = racingGameResult.getWinners();
		for(Car car : winners) {
			names.add(car.getName());
		}
		System.out.println(String.format("%s가 최종 우승했습니다.",names.toString()));
	}
}
