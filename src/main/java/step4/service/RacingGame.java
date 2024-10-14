package step4.service;

import static step4.domain.builder.Director.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import step4.domain.car.Car;
import step4.domain.car.CarList;
import step4.domain.race.CarHistory;
import step4.domain.race.RaceResult;
import step4.dto.UserInput;
import step4.exception.CarNameLengthUnvalidException;
import step4.exception.CarNameNestedException;

public class RacingGame {
	public static final String COMMA_SEPARATOR = ",";

	public static RaceResult race(UserInput userInput) {
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
		if (name.length() > 5) {
			throw new CarNameLengthUnvalidException();
		}
	}

	private static CarList makeDefaultCars(String[] nameList) {
		List<Car> cars = new ArrayList<>();
		for (String name : nameList) {
			cars.add(constructDefaultRandomMoveCar(name));
		}
		return new CarList(cars);
	}

	private static RaceResult getRacingHistory(UserInput userInput, CarList cars) {
		CarHistory racingHistory = new CarHistory();
		for (int i = 0; i < userInput.getMoveCount(); i++) {
			cars.moveAll();
			racingHistory.writeHistory(cars);
		}
		return new RaceResult(racingHistory.getRaceHistory());
	}
}
