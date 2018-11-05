package racinggame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.Car;

public class CarGenerator {

	public static List<Car> generate(String carNames) {
		return Arrays.stream(carNames.split("\\b[\\s,]+\\b"))
				.map(carName -> new Car(carName))
				.collect(Collectors.toList());
	}
}
