package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.domain.Car;
import step4_racingcar_winner.dto.CarDTO;

public class CarDTOTest {

	@DisplayName("CarDTO 생성 테스트")
	@Test
	void carDTOConstructorAndGetPosition() {
		String carName = "test";
		int position = 5;
		Car car = new Car(carName , 0 , bound -> 6);

		for (int i = 0; i < position; i++) {
			car.tryMove();
		}

		CarDTO carDTO = new CarDTO(car);
		assertEquals(carName, carDTO.getName());
		assertEquals(position, carDTO.getPosition());
	}

}
