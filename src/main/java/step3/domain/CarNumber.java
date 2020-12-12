package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step3.utils.ValidationUtils;

public class CarNumber {
	private final int number;

	public CarNumber(int number) {
		ValidationUtils.validPositive(number);
		this.number = number;
	}

	public List<Car> createCars() {
		return IntStream.range(0, number)
			.boxed()
			.map(integer -> new Car())
			.collect(Collectors.toList());
	}
}
