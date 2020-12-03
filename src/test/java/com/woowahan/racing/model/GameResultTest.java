package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

	@DisplayName("of 메서드로 GameResult Instance를 얻을 수 있다.")
	@Test
	void of() {

		GameResult result = GameResult.of(Arrays.asList(Car.getInstance(), Car.getInstance()));

		assertThat(result).isInstanceOf(GameResult.class);
	}

	@DisplayName("of 메서드로 전달한 Car의 객체들은 deep copy되어 필드에 저장된다.")
	@Test
	void ofDeepCopy() {

		Car car1 = Car.getInstance();
		car1.move(true);
		Car car2 = Car.getInstance();
		car2.move(true);

		GameResult gameResult = GameResult.of(Arrays.asList(car1, car2));
		List<Car> resultList = gameResult.getCarList();

		assertAll(
			() -> assertThat(resultList.get(0)).isNotEqualTo(car1),
			() -> assertThat(resultList.get(1)).isNotEqualTo(car2),
			() -> assertThat(resultList.get(0).getDistance()).isEqualTo(car1.getDistance()),
			() -> assertThat(resultList.get(1).getDistance()).isEqualTo(car2.getDistance())
		);
	}
}