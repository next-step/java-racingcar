package racing.view;

import java.text.MessageFormat;
import java.util.List;

import racing.domain.Car;
import racing.domain.RacingCars;

public class ResultView {

	private static final String COMMA_DELIMETER = ",";
	private static final String WINNER_PRINT_FORMAT = "{0}가 최종 우승하였습니다.";
	private static final String NO_WINNER_PRINT_FORMAT = "우승자가 없습니다.";

	public ResultView() {
	}

	public void printCarStatuses(RacingCars racingCars) {
		for (int i = 0; i < racingCars.getRacingCars().size(); i++) {
			printCarName(racingCars.getRacingCars().get(i));
			printCarLocation(racingCars.getRacingCars().get(i));
		}
	}

	private void printCarName(Car car) {
		System.out.print(car.getName() + " : ");
	}

	private void printCarLocation(Car car) {
		for (int i = 0; i < car.getLocation(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printWinners(List<Car> winners) {
		if (winners.isEmpty()) {
			System.out.println(NO_WINNER_PRINT_FORMAT);
			return;
		}
		CharSequence[] winnerNames = winners.stream()
			.map(Car::getName)
			.toArray(CharSequence[]::new);

		System.out.print(MessageFormat.format(WINNER_PRINT_FORMAT, String.join(COMMA_DELIMETER, winnerNames)));
	}
}
