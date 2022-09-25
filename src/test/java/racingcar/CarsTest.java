package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("n대의 자동차는 전진할 수 있다")
	void n_cars_can_move() {
		NumberStrategy numberStrategy = new FixedNumber(4);
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			carList.add(new Car(numberStrategy));
		}
		Cars cars = new Cars(carList);
		cars.move();

		Car notMovedCar = new Car(numberStrategy);

		assertThat(carList).allSatisfy(
			car -> assertThat(car).isGreaterThan(notMovedCar));
	}
}
