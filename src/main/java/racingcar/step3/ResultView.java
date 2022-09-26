package racingcar.step3;

import java.util.List;

public class ResultView {

	private static final char DASH_MARK = '-';
	private static final char LINE_BREAK_CHARACTER = '\n';

	public void printEachTryResult(List<Car> cars) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : cars) {
			stringBuilder.append(toDashMark(car.getPosition()));
		}
		System.out.println(stringBuilder);
	}

	private String toDashMark(int carPosition) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < carPosition; i++) {
			stringBuilder.append(DASH_MARK);
		}
		stringBuilder.append(LINE_BREAK_CHARACTER);
		return stringBuilder.toString();
	}
}
