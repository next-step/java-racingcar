package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.Car;
import racing.car.CarList;
import racing.game.Game;


import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

	@Test
	@DisplayName("자동차의 초기 위치는 모두 1 이다")
	void init() {
		int cars = 3;
		CarList carList = new CarList(cars);
		Car[] carListAll = carList.getAll();

		for (Car car : carListAll) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	static class AlwaysReturn4 extends Random {

		@Override
		public int nextInt() {
			return 4;
		}
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진한다")
	void move_all_cars() {
		int cars = 3;
		Game game = new Game(new AlwaysReturn4());
		CarList carList = new CarList(cars);

		carList.moveAll(game.bounds(cars));

		for (Car car : carList.getAll()) {
			assertThat(car.getPosition()).isEqualTo(2);
		}

	}
}
