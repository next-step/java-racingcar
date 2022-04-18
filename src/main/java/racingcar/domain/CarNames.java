package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import exception.DuplicateCarNameException;

public class CarNames {
	private final List<CarName> carNames;

	public CarNames(String[] names) {
		this.carNames = Arrays.stream(names)
			.collect(Collectors.toCollection(LinkedHashSet::new))
			.stream()
			.map(CarName::new)
			.collect(Collectors.toList());

		validateDuplicateName(names);
	}

	private void validateDuplicateName(String[] names) {
		if (carNames.size() != names.length) {
			throw new DuplicateCarNameException("자동차 이름은 중복이 불가합니다.");
		}
	}

	public List<Car> createCars() {
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
