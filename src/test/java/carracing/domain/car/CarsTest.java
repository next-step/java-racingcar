package carracing.domain.car;

import carracing.domain.game.MaxMoving;
import carracing.domain.game.MovingStrategy;
import carracing.domain.game.RandomRange;
import carracing.domain.game.WinnerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
	private MovingStrategy randomRange;
	private WinnerStrategy maxMoving;

	@BeforeEach
	void setUp() {
		randomRange = new RandomRange(1, 1);
		maxMoving = new MaxMoving();
	}

	@Test
	void newObject_emptyCars_throwsException() {
		List<Car> emptyCars = new ArrayList<>();

		assertThatThrownBy(() -> new Cars(emptyCars))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void isWinners_twoWinners_true() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(10, "abc");
		Car car3 = new Car(8, "abc");
		Cars cars = new Cars(List.of(car1, car2, car3));

		Winners winners = cars.winners(maxMoving);
		Cars winCars = new Cars(List.of(car1, car2));

		assertThat(winners.isWinners(winCars)).isTrue();
	}

	@Test
	void isWinners_twoWinners_false() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(9, "abc");
		Cars cars = new Cars(List.of(car1, car2));

		Winners winners = cars.winners(maxMoving);
		Cars winCars = new Cars(List.of(car2));

		assertThat(winners.isWinners(winCars)).isFalse();
	}

	@Test
	void race_threeCars_fiveTries_oneWinners() {
		Car car1 = new Car(5, "abc");
		Car car2 = new Car(3, "abc");
		Car car3 = new Car(1, "abc");
		Cars cars = new Cars(List.of(car1, car2, car3));

		cars.race(randomRange, 5);
		Winners winners = cars.winners(maxMoving);
		Cars winCars = new Cars(List.of(car1));

		assertThat(winners.isWinners(winCars)).isTrue();
	}

	@Test
	void winners_threeCars_oneTry_oneWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(9, "abc");
		Car car3 = new Car(8, "abc");
		Cars cars = new Cars(List.of(car1, car2, car3));

		cars.race(randomRange);
		Winners winners = cars.winners(maxMoving);
		Cars winCars = new Cars(List.of(car1));

		assertThat(winners.isWinners(winCars)).isTrue();
	}

	@Test
	void winners_threeCars_twoWinners() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(10, "abc");
		Car car3 = new Car(8, "abc");
		Cars cars = new Cars(List.of(car1, car2, car3));

		cars.race(randomRange);
		Winners winners = cars.winners(maxMoving);
		Cars winCars = new Cars(List.of(car1, car2));

		assertThat(winners.isWinners(winCars)).isTrue();
	}
}
