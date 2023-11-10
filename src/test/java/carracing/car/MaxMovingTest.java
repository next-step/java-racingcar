package carracing.car;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MaxMovingTest {
	@Test
	void winners_emptyCars_throwsException() {
		List<Car> emptyCars = new ArrayList<>();
		WinnerStrategy maxMoving = new MaxMoving();

		assertThatThrownBy(
				() -> maxMoving.winners(emptyCars)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void winners_threeCars_oneWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(9, "abc");
		Car car3 = new Car(8, "abc");
		List<Car> cars = List.of(car1, car2, car3);
		WinnerStrategy maxMoving = new MaxMoving();

		List<Car> winners = maxMoving.winners(cars);

		assertThat(winners).isEqualTo(List.of(car1));
	}

	@Test
	void winners_threeCars_twoWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(10, "abc");
		Car car3 = new Car(8, "abc");
		List<Car> cars = List.of(car1, car2, car3);
		WinnerStrategy maxMoving = new MaxMoving();

		List<Car> winners = maxMoving.winners(cars);

		assertThat(winners).isEqualTo(List.of(car1, car2));
	}
}