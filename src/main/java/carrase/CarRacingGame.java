package carrase;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {
	private final LinkedList<RacingCar> cars;

	public CarRacingGame(int CountOfCar) {
		cars = new LinkedList<RacingCar>();
		for(int i = 0; i < CountOfCar; i++) {
			cars.add(new RacingCar(""));
		}
	}

	public List<Integer> start() {
		cars.forEach(racingCar -> {
			CarBehavior behavior = CarBehavior.getCarBehavior(CarUtil.makeRadomNumber());
			behavior.apply(racingCar);
		});
		return cars.stream()
			.map(RacingCar::getMileage)
			.collect(Collectors.toList());
	}
}
