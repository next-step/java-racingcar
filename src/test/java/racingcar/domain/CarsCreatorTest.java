package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsCreatorTest {
	@Test
	@DisplayName("입력된 Names의 Name 리스트로 Car 리스트를 만들어 Cars를 생성한다.")
	void createCarsTest() {
		Cars cars = CarsCreator.create(new Names("test1,test2,test3"));

		assertThat(cars).isInstanceOf(Cars.class);
		assertThat(cars.getCars())
			.hasSize(3)
			.containsExactly(new Car("test1"), new Car("test2"), new Car("test3"));
	}
}