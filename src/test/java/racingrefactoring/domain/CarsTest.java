package racingrefactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

	@Test
	@DisplayName("자동차 대수 설정")
	void set_up_car() throws Exception {
		//given
		String[] carNames = {"car1", "car2", "car3"};

		//when
		Cars cars = new Cars(carNames);

		//then
		assertThat(cars.size()).isEqualTo(carNames.length);
	}

	@Test
	@DisplayName("우승자가 1명인 경우")
	void winner() throws Exception {
		//given
		Car car1 = new Car("car1", 0);
		Car car2 = new Car("car2", 1);
		Car car3 = new Car("car3", 0);
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));

		//when
		Cars winners = cars.findWinners();


		//then
		assertThat(winners.list()).hasSize(1)
		                          .containsExactly(car2);

	}

	@Test
	@DisplayName("우승자가 1명 이상인 경우")
	void one_or_more_winners() throws Exception {
		//given
		Car car1 = new Car("car1", 1);
		Car car2 = new Car("car2", 0);
		Car car3 = new Car("car3", 1);
		Car car4 = new Car("car4", 0);
		Car car5 = new Car("car5", 1);
		Cars cars = new Cars(Arrays.asList(car1, car2, car3));

		//when
		Cars winners = cars.findWinners();

		//then
		assertThat(winners.size()).isPositive();
		assertThat(winners.list()).containsAnyOf(car1, car3, car5);

	}

}
