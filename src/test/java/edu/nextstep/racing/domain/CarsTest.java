package edu.nextstep.racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars : 자동차 목록의 일급컬렉션")
class CarsTest {

	@DisplayName("getAll : 컬랙션의 모든 자동차를 List로 얻음. 생성자로 생성할 때 전달한 자동차 List와 동일해야 함.")
	@Test
	void getAll() {
		Car car1 = new Car("pobi", 1);
		Car car2 = new Car("crong", 3);
		Car car3 = new Car("honux", 3);
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));

		assertThat(cars.getAll()).containsSequence(car1, car2, car3);
	}

	@DisplayName("moveAll : 모든 자동차를 각 차의 이동전략에 따라 이동함.")
	@Test
	void moveAll() {
		Car car1 = new Car("pobi", 1, Car.ALWAYS_MOVE_STRATEGY);
		Car car2 = new Car("crong", 3, Car.ALWAYS_MOVE_STRATEGY);
		Car car3 = new Car("honux", 3, Car.NEVER_MOVE_STRATEGY);
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));

		cars.moveAll();

		assertThat(cars.getAll().get(0).getLocation()).isEqualTo(new Location(2));
		assertThat(cars.getAll().get(1).getLocation()).isEqualTo(new Location(4));
		assertThat(cars.getAll().get(2).getLocation()).isEqualTo(new Location(3));
	}

	@DisplayName("getHeadCars : 모든 자동차를 서로 비교했을 때 가장 결과가 큰(=location이 큰) 자동차들을 다시 일급컬랙션으로 리턴함.")
	@Test
	void getHeadCars() {
		Car car1 = new Car("pobi", 1);
		Car car2 = new Car("crong", 3);
		Car car3 = new Car("honux", 3);
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));

		assertThat(cars.getHeadCars().getAll())
			.hasSize(2)
			.contains(car2, car3);
	}
}