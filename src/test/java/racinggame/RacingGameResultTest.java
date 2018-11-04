package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Car;
import racinggame.utils.CarTestUtils;

public class RacingGameResultTest {

	private List<Car> cars;

	@Before
	public void setUp() {
		cars = new ArrayList<>();
	}

	@Test
	public void 우승자_검증() {
		Car car1 = new Car("pobi");
		CarTestUtils.move(car1, 5);
		cars.add(car1);
		Car car2 = new Car("crong");
		CarTestUtils.move(car2, 4);
		cars.add(car2);
		Car car3 = new Car("honux");
		CarTestUtils.move(car3, 3);
		cars.add(car3);

		RacingGameResult racingGameResult = new RacingGameResult(cars);
		assertThat(racingGameResult.getWinners()).contains(car1);
	}

	@Test
	public void 여러명_우승자_검증() {
		Car car1 = new Car("pobi");
		CarTestUtils.move(car1, 5);
		cars.add(car1);
		Car car2 = new Car("crong");
		CarTestUtils.move(car2, 5);
		cars.add(car2);
		Car car3 = new Car("honux");
		CarTestUtils.move(car3, 3);
		cars.add(car3);

		RacingGameResult racingGameResult = new RacingGameResult(cars);
		assertThat(racingGameResult.getWinners()).containsExactlyInAnyOrder(car1, car2);
	}
}