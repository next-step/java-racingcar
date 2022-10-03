package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName(", 로 분리된 배열을 받아서 List<Car> 생성")
	void createCars() {
		Cars cars = new Cars(new String[] {"pobi", "crong", "honux"});
		assertThat(cars.getCars().size()).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차들 움직임 테스트")
	void move() {
		Cars cars = new Cars(new String[] {"pobi", "wuga"});
		cars.getCars().get(0).movingOfRound(3);
		cars.getCars().get(1).movingOfRound(4);

		assertThat(cars.getCars().get(0).getStatus()).isEqualTo(0);
		assertThat(cars.getCars().get(1).getStatus()).isEqualTo(1);
	}
}
