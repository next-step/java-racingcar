package step3_racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3_racingcar.dto.CarDTO;

public class CarDTOTest {

	@DisplayName("CarDTO 생성 테스트")
	@Test
	void carDTOConstructorAndGetPosition() {
		int position = 5;
		CarDTO carDTO = new CarDTO(position);
		assertEquals(position, carDTO.getPosition());
	}

}
