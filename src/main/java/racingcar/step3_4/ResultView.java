package racingcar.step3_4;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

	private static final char DASH_MARK = '-';

	public void printEachTryResult(List<Car> cars) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : cars) {
			stringBuilder.append(car.getName());
			stringBuilder.append(" : ");
			stringBuilder.append(toDashMark(car.getPosition()));
		}
		System.out.println(stringBuilder);
	}

	private String toDashMark(int carPosition) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < carPosition; i++) {
			stringBuilder.append(DASH_MARK);
		}
		stringBuilder.append(System.lineSeparator());
		return stringBuilder.toString();
	}

	public void printWinners(List<Car> winners) {
		System.out.println(getWinnersName(winners) + "가 최종 우승했습니다.");
	}

	private String getWinnersName(List<Car> winners) {
		return winners.stream()
			.map(Car::getName)
			.map(Name::toString)
			.collect(Collectors.joining(", "));
	}
}
