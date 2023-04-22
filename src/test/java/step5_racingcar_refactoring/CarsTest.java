package step5_racingcar_refactoring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5_racingcar_refactoring.domain.Cars;

public class CarsTest {

	private static final String[] carNames = "f1,suv,sport,super,jeep".split(",");


	@DisplayName("Cars 클래스 생성 사이즈 확인")
	@Test
	void testCarsCreation() {
		Cars cars = new Cars(carNames);
		assertEquals(carNames.length, cars.getCars().size());
	}
}
