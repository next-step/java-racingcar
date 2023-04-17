package step3_racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3_racingcar.domain.Car;
import step3_racingcar.dto.CarDTO;

public class CarDTOTest {

	@DisplayName("CarDTO 생성 테스트")
	@Test
	void carDTOConstructorAndGetPosition() {
		int position = 5;
		Car car = new Car();

		for (int i = 0; i < position; i++) {
			car.tryMove(true);
		}

		CarDTO carDTO = new CarDTO(car);
		assertEquals(position, carDTO.getPosition());
	}

}
