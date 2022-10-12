package study.step5.domain.util;

import java.util.List;
import java.util.stream.Collectors;

import study.step5.domain.car.Car;
import study.step5.domain.car.Cars;

public class StringUtil {

	public static Cars toCars(List<String> names) {
		List<Car> carList =  names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(carList);
	}
}
