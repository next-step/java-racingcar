package carracing.car;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
	@Test
	void newObject_emptyCars_throwsException() {
		List<Car> emptyCars = new ArrayList<>();

		assertThatThrownBy(() -> new Cars(emptyCars))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void race_threeCars_oneWinners() {
		Car car1 = new Car(5, "abc");
		Car car2 = new Car(3, "abc");
		Car car3 = new Car(1, "abc");
		MovingStrategy randomRange = new RandomRange(1, 1);
		WinnerStrategy maxMoving = new MaxMoving();

		Cars cars = new Cars(List.of(car1, car2, car3));
		cars.race(randomRange, 5);
		List<Car> racingCars = cars.winners(maxMoving);

		assertThat(racingCars).isEqualTo(List.of(car1));
	}

	@Test
	void winners_threeCars_oneWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(9, "abc");
		Car car3 = new Car(8, "abc");
		WinnerStrategy maxMoving = new MaxMoving();

		Cars cars = new Cars(List.of(car1, car2, car3));
		List<Car> racingCars = cars.winners(maxMoving);

		assertThat(racingCars).isEqualTo(List.of(car1));
	}

	@Test
	void winners_threeCars_twoWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(10, "abc");
		Car car3 = new Car(8, "abc");
		WinnerStrategy maxMoving = new MaxMoving();

		Cars cars = new Cars(List.of(car1, car2, car3));
		List<Car> racingCars = cars.winners(maxMoving);

		assertThat(racingCars).isEqualTo(List.of(car1, car2));
	}
}
