package step5.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.model.Car;
import step4.model.Cars;
import step4.model.Winners;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {

	Cars cars;
	Winners winners;

	@BeforeEach
	void beforeEach() {
		cars = new Cars(Arrays.asList(
				new Car("hi", 2),
				new Car("hy", 2),
				new Car("hu", 0),
				new Car("ho", 1)
		));
		winners = new Winners();
	}

	@Test
	void 우승자_정상출력_테스트() {
		assertThat(winners.getWinners(cars)).isEqualTo("hi, hy");
	}
}