package carrace;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
	Car car;

	@BeforeEach
	public void init() {
		car = new Car();
	}
	
	@ParameterizedTest
	@CsvSource(value = {"2:2", "3:3", "4:4"}, delimiter = ':')
	public void 차_이동_테스트(int step, int expectedResult) throws Exception {
	    // given
		// when
		car.move(step);
		// then
		int actualResult = car.getPosition();
	    assertThat(actualResult).isEqualTo(expectedResult);
	}
}