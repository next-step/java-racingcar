package step5.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5.domain.movestrategy.CarMoveStrategy;
import step5.domain.movestrategy.RandomMoveStrategy;

class CarTest {
	private static final CarMoveStrategy TEST_ALWAYS_MOVE_STRATEGY = new RandomMoveStrategy(new Return4Random());
	private static final int SPEED = 1;

	@Test
	@DisplayName("move() 메소드를 호출했을 때 speed 만큼 움직이는지 체크하는 테스트")
	void carMoveTest() {
		Car car = Car.builder().setName("a").setSpeed(SPEED).setStrategy(TEST_ALWAYS_MOVE_STRATEGY).build();
		car.move();
		assertThat(car.getPosition()).isEqualTo(new Position(SPEED));
	}

	@Test
	@DisplayName("CarList를 move() 했을 때 전체 Car가 움직이는지 체크하는 테스트")
	void carsMoveAllTest() {
		Car car1 = Car.builder().setName("a").setSpeed(SPEED).setStrategy(TEST_ALWAYS_MOVE_STRATEGY).build();
		Car car2 = Car.builder().setName("b").setSpeed(SPEED).setStrategy(TEST_ALWAYS_MOVE_STRATEGY).build();
		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		CarList carList = new CarList(cars);

		carList.moveAll();
		for (Car car : cars) {
			assertThat(car.getPosition()).isEqualTo(new Position(SPEED));
		}

	}

	static class Return4Random extends Random {
		@Override
		public int nextInt(int value) {
			return 4;
		}
	}
}