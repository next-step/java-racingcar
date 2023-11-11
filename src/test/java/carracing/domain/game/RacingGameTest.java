package carracing.domain.game;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import carracing.domain.car.Winners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
	MovingStrategy randomRange;
	WinnerStrategy maxMoving;

	@BeforeEach
	void setUp() {
		randomRange = new RandomRange(1, 1);
		maxMoving = new MaxMoving();
	}

	@Test
	void race_threeCars_fiveTriesWithMaxMoving_oneWinner() {
		Car car1 = new Car(5, "abc");
		Car car2 = new Car(3, "abc");
		Car car3 = new Car(1, "abc");
		Cars racingCars = new Cars(List.of(car1, car2, car3));
		Cars winCars = new Cars(List.of(car1));

		RacingGame racingGame = new RacingGame(racingCars);
		racingGame.race(randomRange, 5);
		Winners winners = racingCars.winners(maxMoving);

		assertThat(winners.isWinners(winCars)).isTrue();
	}

	@Test
	void race_threeCars_oneTryWithMaxMoving_oneWinner() {
		Car car1 = new Car(5, "abc");
		Car car2 = new Car(3, "abc");
		Car car3 = new Car(1, "abc");
		Cars racingCars = new Cars(List.of(car1, car2, car3));
		Cars winCars = new Cars(List.of(car1));

		RacingGame racingGame = new RacingGame(racingCars);
		racingGame.race(randomRange);
		Winners winners = racingCars.winners(maxMoving);

		assertThat(winners.isWinners(winCars)).isTrue();
	}
}
