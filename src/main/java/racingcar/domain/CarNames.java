package racingcar.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import exception.DuplicateCarNameException;

public class CarNames {
	public static final String CAR_NAME_SPLIT_REGEX = ",";
	private final Set<CarName> carNames;

	public CarNames(String fullNameValue) {
		String[] splitNames = fullNameValue.split(CAR_NAME_SPLIT_REGEX);

		this.carNames = Arrays.stream(fullNameValue.split(CAR_NAME_SPLIT_REGEX))
			.map(CarName::new)
			.collect(Collectors.toCollection(LinkedHashSet::new));

		validateDuplicateName(splitNames);
	}

	public Set<CarName> values() {
		return carNames;
	}

	private void validateDuplicateName(String[] names) {
		if (this.carNames.size() != names.length) {
			throw new DuplicateCarNameException("자동차 이름은 중복이 불가합니다.");
		}
	}
}
