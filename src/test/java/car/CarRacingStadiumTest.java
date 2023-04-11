package car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingStadiumTest {

	@DisplayName("가장 많이 이동한 자동차의 위치를 확인한다.")
	@Test
	void test1() {
		CarRacingStadium carRacingStadium = new CarRacingStadium();
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("pobi", 3));
		cars.add(new Car("crong", 5));
		cars.add(new Car("honux", 5));

		assertThat(carRacingStadium.getBestLocation(cars)).isEqualTo(5);
	}

	@DisplayName("우승자를 선별한다.")
	@Test
	void test2() {
		CarRacingStadium carRacingStadium = new CarRacingStadium();
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("pobi", 3));
		cars.add(new Car("crong", 5));
		cars.add(new Car("honux", 5));

		assertThat(carRacingStadium.createWinners(cars, 5))
			.containsExactly("crong", "honux");
	}
}
