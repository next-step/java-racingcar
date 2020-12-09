package racing.domain;

import racing.model.*;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.*;

public class RacingGame {

	public static final String CAR_NAME_DELIMITER = ",";

	ResultView resultView = new ResultView();

	public void start() {
		InputView inputView = new InputView();

		List<Car> cars = prepareInitRacingCar(inputView.getInputName());
		startRacing(cars, inputView.getPlayCount());
		FinalRacingResult finalWinner = findWinner(cars);

		resultView.printFinalWinner(finalWinner.getWinnerName());
	}

	public FinalRacingResult findWinner(List<Car> cars) {
		List<Integer> positionList = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		for (Car car : cars) {
			positionList.add(car.getForwardPosition());
			map.merge(car.getForwardPosition(), car.getName(), (k, v) -> map.get(car.getForwardPosition()) + CAR_NAME_DELIMITER + car.getName());
		}
		Integer maxPosition = Collections.max(positionList);
		String winnerName = map.get(maxPosition);

		FinalRacingResult finalRacingResult = new FinalRacingResult(maxPosition, map, winnerName);
		return finalRacingResult;
	}

	public void startRacing(List<Car> cars, int playCount) {
		for (int i = 0; i < playCount; i++) {
			speedUpForPlayCount(cars);
			System.out.println();
		}
	}

	//https://github.com/next-step/java-racingcar/pull/1623#discussion_r536464659
	public void speedUpForPlayCount(List<Car> cars) {
		for (Car car : cars) {
			car.speedUp(new RandomForward());
			resultView.print(car.getName(), car.getForwardPosition());
		}
	}

	public List<Car> prepareInitRacingCar(String inputName) {
		String[] carNames = inputName.split(CAR_NAME_DELIMITER);
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return cars;

	}

}