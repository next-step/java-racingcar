package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Car;

public class CarTest {
	private Car car;

	@BeforeEach
	void init() {
		car = new Car();
	}

	@DisplayName(value = "자동차 전진 테스트")
	@CsvSource(value = {"1:0", "4:1", "8:1"}, delimiter = ':')
	@ParameterizedTest
	void advanceOrStop(int randomNumber, int expect) {
		car.advanceOrStop(randomNumber);
		int result = car.getPosition();
		assertThat(result).isEqualTo(expect);
	}
}
