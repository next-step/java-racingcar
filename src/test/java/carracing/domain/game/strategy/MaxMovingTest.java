package carracing.domain.game.strategy;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import carracing.domain.car.Winners;
import carracing.domain.game.MaxMoving;
import carracing.domain.game.WinnerStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MaxMovingTest {
	@Test
	void winners_emptyCars_throwsException() {
		WinnerStrategy maxMoving = new MaxMoving();

		assertThatThrownBy(
				() -> maxMoving.winners(new Cars(new ArrayList<>()))
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void winners_threeCars_oneWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(9, "abc");
		Car car3 = new Car(8, "abc");
		Cars cars = new Cars(List.of(car1, car2, car3));
		WinnerStrategy maxMoving = new MaxMoving();

		Winners winners = maxMoving.winners(cars);
		Cars winCars = new Cars(List.of(car1));

		assertThat(winners.isWinners(winCars)).isTrue();
	}

	@Test
	void winners_threeCars_twoWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(10, "abc");
		Car car3 = new Car(8, "abc");
		Cars cars = new Cars(List.of(car1, car2, car3));
		WinnerStrategy maxMoving = new MaxMoving();

		Winners winners = maxMoving.winners(cars);
		Cars winCars = new Cars(List.of(car1, car2));

		assertThat(winners.isWinners(winCars)).isTrue();
	}
}