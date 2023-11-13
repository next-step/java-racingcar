package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.car.Car;
import racing.model.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

	@ParameterizedTest
	@DisplayName("자동차는 bound()값이 4미만일 때 가만히 있고 4이상일 때 전진한다")
	@CsvSource({"0,1", "1,1", "2,1", "3,1", "4,2", "5,2", "6,2", "7,2", "8,2", "9,2"})
	void move(Integer bound, Integer expected) {
		Car car = new Car(4, 1, 1, new CarName(""));
		car.move(bound);
		assertThat(car.getPosition()).isEqualTo(expected);
	}
}
