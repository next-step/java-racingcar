package camp.nextstep.edu.racingcar.module;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.racingcar.entity.Car;

public class RacingCarGame {

	public void moveCars(List<Car> cars, int randomNumber) {
		cars.forEach(car -> car.move(randomNumber));
	}

	public List<Car> generateCars(int input) {
		return IntStream.range(0, input)
			.boxed()
			.map((Integer t) -> new Car())
			.collect(Collectors.toList());
	}
}
