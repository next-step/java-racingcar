package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	private static final String TEST_CAR_NAME = "CAR";

	@DisplayName("move() 움직였을 경우 테스트")
	@Test
	void moveTest() {
		RandomNum moveRandomNum = new MoveRandomNum();
		Car car = new Car(TEST_CAR_NAME, moveRandomNum);

		int preCarLocation = car.getLocation();

		car.move();

		Assertions.assertThat(car.getLocation()).isGreaterThan(preCarLocation);
	}

	@DisplayName("move() 움직이지 않았을 경우 테스트")
	@Test
	void notMoveTest() {
		RandomNum notMoveRandomNum = new NotMoveRandomNum();
		Car car = new Car(TEST_CAR_NAME, notMoveRandomNum);

		int preCarLocation = car.getLocation();

		car.move();

		Assertions.assertThat(car.getLocation()).isEqualTo(preCarLocation);
	}
}
