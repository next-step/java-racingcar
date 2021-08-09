package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarNumberGenerator;
import racingcar.domain.Cars;

public class CarsTest {

	@Test
	@DisplayName("우승자 찾기")
	void winners() {
		Car pobi = new Car("pobi", 1);
		Car crong = new Car("crong", 2);
		Car honux = new Car("honux", 3);
		Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
		assertThat(cars.getWinners()).containsExactly(honux);
	}

	@Test
	@DisplayName("이동")
	void move() {
		Car pobi = new Car("pobi");
		Cars cars = new Cars(Arrays.asList(pobi));
		cars.move(() -> 4);
		assertThat(cars.toList()).containsExactly(pobi);
		assertThat(pobi).isEqualByComparingTo(new Car("pobi2", 1));
	}

	@Test
	@DisplayName("이동 후 우승자 찾기")
	void moveAndWinners() {
		Car pobi = new Car("pobi");
		Car crong = new Car("crong");
		Car honux = new Car("honux");
		Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
		cars.move(new CarNumberGenerator() {
			List<Integer> numbers = Arrays.asList(4, 4, 3);
			int index = 0;

			@Override
			public int generate() {
				return numbers.get(index++);
			}
		});
		assertThat(cars.getWinners()).containsExactly(pobi, crong);
	}
}