package racing.view;

import static java.lang.System.*;

import java.text.MessageFormat;
import java.util.List;

import racing.domain.Car;
import racing.domain.RacingCars;

public class ResultView {

	private static final String LINE_BREAK = "\n";
	private static final String COMMA_DELIMETER = ",";
	private static final String WINNER_PRINT_FORMAT = "{0}가 최종 우승하였습니다.";
	private static final String NO_WINNER_PRINT_FORMAT = "우승자가 없습니다.";

	public void printCarStatuses(RacingCars racingCars) {
		for (int i = 0; i < racingCars.getRacingCars().size(); i++) {
			printCarName(racingCars.getRacingCars().get(i));
			printCarLocation(racingCars.getRacingCars().get(i));
			print(LINE_BREAK);
		}
		print(LINE_BREAK);
	}

	private void printCarName(Car car) {
		print(car.getName() + " : ");
	}

	private void printCarLocation(Car car) {
		for (int i = 0; i < car.getLocation(); i++) {
			print("-");
		}
	}

	public void printWinners(List<Car> winners) {
		if (winners.isEmpty()) {
			print(NO_WINNER_PRINT_FORMAT);
			print(LINE_BREAK);
			return;
		}
		CharSequence[] winnerNames = winners.stream()
			.map(Car::getName)
			.toArray(CharSequence[]::new);

		print(MessageFormat.format(WINNER_PRINT_FORMAT, String.join(COMMA_DELIMETER, winnerNames)));
	}

	public void printExceptionMessage(Exception exception) {
		print(exception.getMessage());
	}

	private void print(String text) {
		out.print(text);
	}
}
