package carRacing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

	@DisplayName("우승자를 만든다.")
	@Test
	void test1() {
		Car pobi = new Car("pobi", new Location(5));
		Car crong = new Car("crong", new Location(5));
		Car honux = new Car("honux", new Location(3));

		List<Car> cars = new ArrayList<>();
		cars.add(pobi);
		cars.add(crong);
		cars.add(honux);

		assertThat(new CarRacing(cars).createWinners()).containsExactly(pobi, crong);
	}
}
