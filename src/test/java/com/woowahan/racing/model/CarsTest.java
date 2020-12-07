package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
		cars = Cars.of(Arrays.asList(CAR_NAME1, CAR_NAME2, CAR_NAME3));
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
	void getWinnersMin() {

		List<String> result = cars.getWinners();
		assertThat(result.size()).isGreaterThanOrEqualTo(MIN_WINNER_COUNT);
	}

	@DisplayName("getWinners메서드 우승자의 이름을 반환하는데 우승자의 이름으로 찾은 Car는 전체 차중에 maxDistance값을 가진다.")
	@Test
	void getWinners() {

		List<String> winners = cars.getWinners();

		List<Car> winnersCars = cars.getCars()
			.stream()
			.filter(car -> winners.contains(car.getName()))
			.collect(Collectors.toList());

		int maxDistance = cars.findMaxDistance();
		for (Car car : winnersCars) {
			assertThat(maxDistance).isEqualTo(car.getDistance());
		}
	}

}
