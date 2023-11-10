package carracing.domain.game;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
	@Test
	void race_threeCars_oneWinners() {
		Car car1 = new Car(5, "abc");
		Car car2 = new Car(3, "abc");
		Car car3 = new Car(1, "abc");
		MovingStrategy randomRange = new RandomRange(1, 1);
		WinnerStrategy maxMoving = new MaxMoving();

		Cars racingCars = new Cars(List.of(car1, car2, car3));
		RacingGame racingGame = new RacingGame(racingCars);
		racingGame.race(randomRange, 5);
		List<Car> winners = racingCars.winners(maxMoving);

		assertThat(winners).isEqualTo(List.of(car1));
	}
}
