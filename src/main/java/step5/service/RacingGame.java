package step5.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import step5.domain.car.Car;
import step5.domain.car.CarList;
import step5.domain.movestrategy.RandomMoveStrategy;
import step5.domain.race.RaceHistory;
import step5.dto.UserInput;
import step5.exception.CarNameLengthUnvalidException;
import step5.exception.CarNameNestedException;

public class RacingGame {
	public static final String COMMA_SEPARATOR = ",";
	private static final RandomMoveStrategy RANDOM_MOVE_STRATEGY = new RandomMoveStrategy(new Random());
	private static final int FIVE = 5;

	public static RaceHistory race(UserInput userInput) {
		String[] nameList = getSplitNameList(userInput.getNameString());
		checkNameListValidElseThrowException(nameList);
		CarList cars = makeDefaultCars(nameList);
		return getRacingHistory(userInput, cars);
	}

	private static String[] getSplitNameList(String nameString) {
		return nameString.split(COMMA_SEPARATOR);
	}

	private static void checkNameListValidElseThrowException(String[] nameList) {
		for (String name : nameList) {
			checkNameIsEmpty(name);
			checkNameIsBiggerFive(name);
		}
		for (String name : nameList) {
			checkNameIsNested(name, nameList);
		}
	}

	private static void checkNameIsNested(String name, String[] nameList) {
		int nestedNameCount = Arrays.stream(nameList).filter((string) -> string.equals(name)).toArray().length;
		if (nestedNameCount > 1) {
			throw new CarNameNestedException();
		}
	}

	private static void checkNameIsEmpty(String name) {
		if (name.isEmpty()) {
			throw new CarNameLengthUnvalidException();
		}
	}

	private static void checkNameIsBiggerFive(String name) {
		if (name.length() > FIVE) {
			throw new CarNameLengthUnvalidException();
		}
	}

	private static CarList makeDefaultCars(String[] nameList) {
		List<Car> cars = new ArrayList<>();
		for (String name : nameList) {
			Car car = Car.builder()
				.setSpeed(1)
				.setStrategy(RANDOM_MOVE_STRATEGY)
				.setName(name)
				.build();
			cars.add(car);
		}
		return new CarList(cars);
	}

	private static RaceHistory getRacingHistory(UserInput userInput, CarList cars) {
		RaceHistory racingHistory = new RaceHistory();
		for (int i = 0; i < userInput.getMoveCount(); i++) {
			cars.moveAll();
			racingHistory.writeHistory(cars);
		}
		return racingHistory;
	}
}
