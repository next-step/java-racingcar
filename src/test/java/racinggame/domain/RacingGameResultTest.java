package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.Test;

public class RacingGameResultTest {

	@Test
	public void 우승자_검증() {
		Car car1 = new Car("pobi", 5);
		Car car2 = new Car("crong", 4);
		Car car3 = new Car("honux", 3);
		List<Car> cars = Arrays.asList(car1, car2, car3);

		RacingGameResult racingGameResult = new RacingGameResult(cars);
		assertThat(racingGameResult.getWinners())
				.extracting("name", "position")
				.containsExactlyInAnyOrder(getTuple(car1));
	}

	@Test
	public void 여러명_우승자_검증() {
		Car car1 = new Car("pobi", 5);
		Car car2 = new Car("crong", 5);
		Car car3 = new Car("honux", 3);
		List<Car> cars = Arrays.asList(car1, car2, car3);

		RacingGameResult racingGameResult = new RacingGameResult(cars);
		assertThat(racingGameResult.getWinners())
				.extracting("name", "position")
				.containsExactlyInAnyOrder(getTuple(car1), getTuple(car2));
	}

	private Tuple getTuple(Car car) {
		return tuple(car.getName(), car.getCurrentPosition());
	}
}