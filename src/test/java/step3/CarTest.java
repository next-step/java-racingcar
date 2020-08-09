package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

	@DisplayName(value = "조건에 따른 자동차의 전진 또는 정지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3:0", "1:0", "4:1", "6:1", "8:1"}, delimiter = ':')
	void moveForward(int value, int expected) {
		Car car = new Car();
		car.moveForward(value);
		assertThat(car.getRecord()).isEqualTo(expected);
	}

}
