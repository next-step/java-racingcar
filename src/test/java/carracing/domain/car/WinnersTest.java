package carracing.domain.car;

import carracing.domain.game.MaxMoving;
import carracing.domain.game.WinnerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
	private WinnerStrategy maxMoving;

	@BeforeEach
	void setUp() {
		maxMoving = new MaxMoving();
	}

	@Test
	void isWinners_twoWinnersWithMaxMoving_true() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(10, "abc");
		Car car3 = new Car(8, "abc");
		Cars cars = new Cars(List.of(car1, car2, car3));
		Cars winCars = new Cars(List.of(car1, car2));

		Winners winners = cars.winners(maxMoving);
		boolean isWinners = winners.isWinners(winCars);

		assertThat(isWinners).isTrue();
	}

	@Test
	void isWinners_twoWinnersWithMaxMoving_false() {
		Car car1 = new Car(10, "abc");
		Car car2 = new Car(9, "abc");
		Cars cars = new Cars(List.of(car1, car2));
		Cars winCars = new Cars(List.of(car2));

		Winners winners = cars.winners(maxMoving);
		boolean isWinners = winners.isWinners(winCars);

		assertThat(isWinners).isFalse();
	}
}
