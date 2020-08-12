package step4;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
	private static List<Car> cars = new ArrayList<>();

	@BeforeAll
	static void setCars() {
		cars = Lists.newArrayList(
				new Car("dami")
				, new Car("son")
				, new Car("corgi")
				, new Car("monza")
		);

		cars.get(1).moveForward(3);
		cars.get(1).moveForward(6);
		cars.get(1).moveForward(1);

		cars.get(2).moveForward(7);
		cars.get(2).moveForward(3);
		cars.get(2).moveForward(8);

		cars.get(3).moveForward(9);
		cars.get(3).moveForward(4);
		cars.get(3).moveForward(2);

	}

	@DisplayName("우승자의 수 확인 테스트")
	@Test
	void findWinner() {
		assertThat(new Winner().findWinner(cars)).hasSize(2);
	}

	@DisplayName("우승자의 기록 확인 테스트")
	@Test
	void findWinnerRecord() {
		assertThat(new Winner().findWinner(cars).get(0).getRecord()).isEqualTo(2);
	}

}