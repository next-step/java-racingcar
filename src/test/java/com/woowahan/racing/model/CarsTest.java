package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private static Cars cars;
	private static final String CAR_NAME1 = "자동차1";
	private static final String CAR_NAME2 = "자동차2";
	private static final String CAR_NAME3 = "자동차3";
	private static final int MIN_WINNER_COUNT = 1;

	@BeforeEach
	void setup() {
		cars = Cars.of(Arrays.asList(
			Car.createCar(CAR_NAME1),
			Car.createCar(CAR_NAME2),
			Car.createCar(CAR_NAME3)
			)
		);
		IntStream.range(0, 5).forEach(idx -> {
			cars.moveCars();
		});
	}

	@DisplayName("of 메서드로 Cars의 객체를 생성할 수 있다.")
	@Test
	void of() {
		assertThat(cars).isInstanceOf(Cars.class);
	}

	@DisplayName("getWinners메서드는 우승자를 최소 1명 이상 반환한다.")
	@Test
	void getWinners() {

		List<String> result = cars.getWinners();
		assertThat(result.size()).isGreaterThanOrEqualTo(MIN_WINNER_COUNT);
	}

}
