package carrase;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRasingGame {
	private final LinkedList<RacingCar> cars;

	public CarRasingGame(int input) {
		cars = new LinkedList<RacingCar>();
		for(int i = 0; i < input; i++) {
			cars.add(new RacingCar());
		}
	}

	public List<Integer> start() {
		cars.stream()
			.forEach(racingCar -> {
				CarBehavior behavior = CarBehavior.getCarBehavior(CarUtil.makeRadomNumber());
				behavior.apply(racingCar);
			});
		return cars.stream()
			.map(RacingCar::getMileage)
			.collect(Collectors.toList());
	}
}
