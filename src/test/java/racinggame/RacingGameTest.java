package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import racinggame.domain.Car;

public class RacingGameTest {

	@Test
	public void 자동차_이동_검증() {
		RacingGame racingGame = new RacingGame(5, 5);

		List<Car> cars = moveWhenGameisOver(racingGame);

		assertThat(cars.stream()
				.filter(car -> car.getCurrentPosition() == 0 || car.getCurrentPosition() >= 4)
				.collect(Collectors.toList())).hasSameSizeAs(cars);
	}

	@Test
	public void 경주가_끝났는지_검증() {
		RacingGame racingGame = new RacingGame(3, 4);

		moveWhenGameisOver(racingGame);

		assertThat(racingGame.isOver()).isTrue();
	}

	private List<Car> moveWhenGameisOver(RacingGame racingGame) {
		List<Car> cars;
		do {
			cars = racingGame.move();
		} while (!racingGame.isOver());
		return cars;
	}
}