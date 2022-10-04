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

	@Test
	@DisplayName("우승자 확인")
	void findWinners() {
		Cars cars = new Cars(new String[] {"aaa", "bbb"});
		cars.getCars().get(0).movingOfRound(1);
		cars.getCars().get(1).movingOfRound(4);

		assertThat(cars.findWinner().get(0).getName()).isEqualTo(new Name("bbb"));
	}

	@Test
	@DisplayName("우승자 위치 확인")
	void bestPosition() {
		Cars cars = new Cars(new String[] {"aaa", "bbb"});
		cars.getCars().get(0).movingOfRound(1);
		cars.getCars().get(1).movingOfRound(4);

		assertThat(cars.findWinner().get(0).getStatus()).isEqualTo(new Position(1));
	}
}
