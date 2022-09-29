package carRacing.level3.service;

import carRacing.level3.domain.Car;
import carRacing.level3.domain.Cars;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarService {

	public Cars prepare(int carSum) {
		return new Cars(
			IntStream.range(0, carSum)
				.mapToObj(index -> new Car())
				.collect(Collectors.toList()));
	}

	public void moveCar(Cars cars,MovingStartegy movingStartegy) {
		cars.moveCarLocation(movingStartegy);
	}

}
