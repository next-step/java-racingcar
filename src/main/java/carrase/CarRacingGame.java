package carrase;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRacingGame {
	private final LinkedList<RacingCar> cars;

	public CarRacingGame(List<String> carNames) {
		cars = new LinkedList<RacingCar>();
		carNames.forEach(carName -> cars.add(new RacingCar(carName)));
	}

	public void start() {
		cars.forEach(racingCar -> {
			CarBehavior behavior = CarBehavior.getCarBehavior(CarUtil.makeRadomNumber());
			behavior.apply(racingCar);
		});
	}

	public Map<String, Integer> getGameResult() {
		return cars.stream()
			.collect(Collectors.toMap(RacingCar::getName, RacingCar::getMileage));
	}
}
