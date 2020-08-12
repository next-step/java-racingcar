package step4;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

	private static Cars cars;

	@BeforeAll
	static void setCars() {
		cars = new Cars(
				Lists.newArrayList(
						new Car("dami")
						, new Car("son")
						, new Car("corgi")
						, new Car("monza")
				)
		);

		cars.getRacingCars().get(1).moveForward(3);
		cars.getRacingCars().get(1).moveForward(6);
		cars.getRacingCars().get(1).moveForward(1);

		cars.getRacingCars().get(2).moveForward(7);
		cars.getRacingCars().get(2).moveForward(3);
		cars.getRacingCars().get(2).moveForward(8);

		cars.getRacingCars().get(3).moveForward(9);
		cars.getRacingCars().get(3).moveForward(4);
		cars.getRacingCars().get(3).moveForward(2);

	}

	@DisplayName("우승자의 수 확인 테스트")
	@Test
	void findWinner() {
		assertThat(cars.findWinner().getRacingCars()).hasSize(2);
	}

	@DisplayName("우승자의 기록 확인 테스트")
	@Test
	void findWinnerRecord() {
		assertThat(cars.findWinner().getRacingCars().get(0).getRecord()).isEqualTo(2);
	}

}