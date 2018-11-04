package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.utils.CarTestUtils.createAndMove;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Car;

public class RacingGameResultTest {

	private List<Car> cars;

	@Before
	public void setUp() {
		cars = new ArrayList<>();
	}

	@Test
	public void 우승자_검증() {
		Car car1 = createAndMove("pobi", 5);
		Car car2 = createAndMove("crong", 4);
		Car car3 = createAndMove("honux", 3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		RacingGameResult racingGameResult = new RacingGameResult(cars);
		assertThat(racingGameResult.getWinners()).contains(car1);
	}

	@Test
	public void 여러명_우승자_검증() {
		Car car1 = createAndMove("pobi", 5);
		Car car2 = createAndMove("crong", 5);
		Car car3 = createAndMove("honux", 3);
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		RacingGameResult racingGameResult = new RacingGameResult(cars);
		assertThat(racingGameResult.getWinners()).containsExactlyInAnyOrder(car1, car2);
	}
}