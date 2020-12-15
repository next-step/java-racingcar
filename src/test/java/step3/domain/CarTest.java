package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
	@ParameterizedTest
	@CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
	@DisplayName("숫자가 4 이상이면 전진 할 수 있다.")
	void isGoTest(int input, boolean expected) {
		assertThat(new Car("test").isGo(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0", "3,0", "4,1", "9,1"})
	@DisplayName("숫자가 4 이상이면 전진 한다.")
	void goOrStopTest(int input, int expected) {
		Car car = new Car("test");
		car.goOrStop(input);
		assertThat(car.getPosition()).isEqualTo(new Position(expected));
	}
}
