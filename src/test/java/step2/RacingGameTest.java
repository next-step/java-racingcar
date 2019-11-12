package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

	@ParameterizedTest
	@CsvSource(value = {"2,2", "3,3", "4,4"})
	void initDataStructure(int carCount, int expected) {
		Car[] cars = RacingGame.initDataStructure(carCount);

		assertThat(cars.length).isEqualTo(expected);
		assertThat(cars[0]).isNotNull();
	}

	@Test
	void doRacing() {
		Car[] cars = new Car[2];
		cars[0] = new Car();
		cars[1] = new Car();

		assertThat(RacingGame.doRacing(cars, 5)).isEqualTo(-1);
	}

	@Test
	void processRacingTurn() {
		Car[] cars = new Car[2];
		cars[0] = new Car();
		cars[1] = new Car();

		Car[] newCars = RacingGame.processRacingTurn(cars);

		assertThat(newCars).isEqualTo(cars);
	}
}