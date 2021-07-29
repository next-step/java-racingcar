package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racing.domain.Car;
import racing.domain.Cars;

public class RacingOutputView {

	private static final String RESULT_MESSAGE = "실행_결과";
	private static final String WINNER_MESSAGE = " 가 최종 우승했습니다.";

	public void racingStartView() {
		System.out.println(RESULT_MESSAGE);
	}

	public void racingResultView(Cars cars) {
		for (Car car : cars.getInformation()) {
			System.out.println(car.printCarName() + intResultToStringResult(car.printPosition()));
		}
		racingRoundClear();
	}

	public void racingRoundClear() {
		System.out.print("\n");
	}

	public void racingWinnerView(List<Car> winnerPlayer) {
		String winners = getWinnerNames(winnerPlayer);
		System.out.println(winners + WINNER_MESSAGE);
	}

	private String getWinnerNames(List<Car> winnerPlayer) {
		return winnerPlayer.stream().map(Car::printCarName).collect(Collectors.joining(","));
	}

	private String intResultToStringResult(int resultRacing) {
		return IntStream.range(0, resultRacing).mapToObj(i -> "-").collect(Collectors.joining());
	}

}
