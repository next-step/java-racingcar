package step3_racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3_racingcar.domain.Cars;

public class CarsTest {
	
	@DisplayName("Cars 클래스 생성 사이즈 확인")
	@Test
	void testCarsCreation() {
		int carCount = 5;
		Cars cars = new Cars(carCount);
		assertEquals(carCount, cars.getCars().size());
	}
}
