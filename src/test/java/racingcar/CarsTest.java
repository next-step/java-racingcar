package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName(", 로 분리된 배열을 받아서 List<Car> 생성")
	void createCars() {
		Cars cars = new Cars(new String[] {"pobi", "crong", "honux"});
		assertThat(cars.getCars().size()).isEqualTo(3);
	}
}
