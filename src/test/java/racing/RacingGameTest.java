package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.car.Car;
import racing.car.CarList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	Game game = new Game();

	@Test
	@DisplayName("bound()의 값은 0이상 9이하이다")
	void nextInt() {
		assertThat(game.bound())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(9);
	}

	@ParameterizedTest
	@DisplayName("자동차는 bound()값이 4미만일 때 가만히 있고 4이상일 때 전진한다")
	@CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
	void move(Integer bound, Integer expected) {
		Car car = new Car();
		car.move(bound);
		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진을 시도할 때 필요한 random ArrayList를 만든다")
	void make_random_list() {
		int cars = 3;

		int[] bounds = game.bounds(cars);

		for (int i = 0; i < cars; i++) {
			assertThat(bounds[i]).isGreaterThanOrEqualTo(0)
					.isLessThanOrEqualTo(9);
		}
	}

	@Test
	@DisplayName("자동차의 초기 위치는 모두 0 이다")
	void init() {
		int cars = 3;
		CarList carList = new CarList(cars);
		Car[] carListAll = carList.getAll();

		for (Car car : carListAll) {
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진한다")
	void move_all_cars() {
		int cars = 3;
		CarList carList = new CarList(cars);
		int[] bounds = {4, 5, 6};

		carList.moveAll(bounds);

		for (Car car : carList.getAll()) {
			assertThat(car.getPosition()).isEqualTo(1);
		}

	}

}
