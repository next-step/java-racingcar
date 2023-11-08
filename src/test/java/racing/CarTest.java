package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

	@ParameterizedTest
	@DisplayName("자동차는 bound()값이 4미만일 때 가만히 있고 4이상일 때 전진한다")
	@CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
	void move(Integer bound, Integer expected) {
		Car car = new Car();
		car.move(bound);
		assertThat(car.getPosition()).isEqualTo(expected);
	}
}
