package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarsCreator {
	public static Cars create(Names names) {
		return new Cars(mapToCars(names.getNameList()));
	}

	private static List<Car> mapToCars(List<String> names) {
		return names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
