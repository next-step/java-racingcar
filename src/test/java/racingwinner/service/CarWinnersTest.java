package racingwinner.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingwinner.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CarWinnersTest {

	@Test
	@DisplayName("우승자가 1명인 경우")
	void one_winner() throws Exception {
		//given
		List<Car> cars = Arrays.asList(
				new Car("car1"),
				new Car("car2"),
				new Car("car3")
		);

		//when
		for (int i = 0; i < 10; i++) {
			cars.get(1).moveForward();
		}

		//then
		assertThat(CarWinners.selectWinners(cars)).hasSize(1)
		                                          .containsExactly("car2");

	}

	@Test
	@DisplayName("우승자가 1명 이상인 경우")
	void one_or_more_winners() throws Exception {
		//given
		List<Car> cars = Arrays.asList(
				new Car("car1"),
				new Car("car2"),
				new Car("car3"),
				new Car("car4"),
				new Car("car5")
		);

		//when
		for (int i = 0; i < 10; i++) {
			cars.get(0).moveForward();
			cars.get(2).moveForward();
			cars.get(4).moveForward();
		}
		Set<String> winners = CarWinners.selectWinners(cars);

		//then
		assertThat(winners.size()).isPositive();
		assertThat(winners).containsAnyOf("car1", "car3", "car5");

	}

}