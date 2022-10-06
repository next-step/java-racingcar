package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Condition;
import racingcar.domain.NumberCondition;
import racingcar.domain.RandomMaker;
import racingcar.domain.RandomStrategy;
import racingcar.ui.InputView;
import racingcar.ui.Print;
import racingcar.ui.Views;

public class Racing extends Condition {
	private static final RandomStrategy random = new RandomMaker();

	public Racing() {
		super(new NumberCondition());
	}

	public void playRace() {
		Print.participantsOfRacing();
		String participant = InputView.input();
		Print.howManyMatches();
		String matches = InputView.input();

		Print.execute();

		Views.winOfRacing(result(participant, checkInput(matches)));
	}

	private static Cars result(String participant, String matches) {
		return playMatches(participate(participant), matches);
	}

	private static Cars playMatches(Cars cars, String matches) {
		for (int i = 0; i < Integer.parseInt(matches); i++) {
			playMatch(cars);
		}
		return cars;
	}

	private static void playMatch(Cars cars) {
		for (int i = 0; i < cars.getCars().size(); i++) {
			cars.move(random.makeRandom(), i);
		}
		Views.results(cars);
	}

	public static Cars participate(String input) {
		List<Car> cars = new ArrayList<>();
		for (String car : input.split(",")) {
			cars.add(new Car(car));
		}
		return new Cars(cars);
	}

	public String checkInput(String input) {
		if (validInput(input)) {
			throw new IllegalArgumentException("판 수는 0 이하 또는 문자가 될 수 없습니다");
		}
		return input;
	}
}
