package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.domain.Car;

public class CarTest {
	private static final String carName = "testCar";

	@DisplayName("자동차 생성")
	@Test
	public void moveTest() {
		Car car = new Car(carName);
		assertEquals("testCar" , car.getName());
	}

	@DisplayName("자동차 전진")
	@Test
	void movableIsTrue() {
		Car car = new Car(carName);
		int initialStatus = car.getPosition();

		car.tryMove(true);
		int movedStatus = car.getPosition();

		assertNotEquals(initialStatus, movedStatus);
	}

	@DisplayName("자동차 정지")
	@Test
	void movableIsFalse() {
		Car car = new Car(carName);
		int initialStatus = car.getPosition();

		car.tryMove(false);
		int notMovedStatus = car.getPosition();

		assertEquals(initialStatus, notMovedStatus);
	}

}
