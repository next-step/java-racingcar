package step3_racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3_racingcar.domain.Car;

public class CarTest {

	@DisplayName("자동차 생성")
	@Test
	public void moveTest() {
		Car car = new Car();
	}

	@DisplayName("자동차 전진")
	@Test
	void movableIsTrue() {
		Car car = new Car();
		int initialStatus = car.getPosition();

		car.tryMove(true);
		int movedStatus = car.getPosition();

		assertNotEquals(initialStatus, movedStatus);
	}

	@DisplayName("자동차 정지")
	@Test
	void movableIsFalse() {
		Car car = new Car();
		int initialStatus = car.getPosition();

		car.tryMove(false);
		int notMovedStatus = car.getPosition();

		assertEquals(initialStatus, notMovedStatus);
	}

}
