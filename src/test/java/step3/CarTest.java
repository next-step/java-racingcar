package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
	@ParameterizedTest
	@CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
	@DisplayName("숫자가 4 이상이면 전진 할 수 있다.")
	void isGoTest(int input, boolean expected) {
		Car car = new Car(new RandomNumberGenerator());
		assertThat(car.isGo(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0", "3,0", "4,1", "9,1"})
	@DisplayName("숫자가 4 이상이면 전진 한다.")
	void goOrStopTest(int input, int expected) {
		Car car = new Car(new DefaultNumberGenerator(input));
		assertThat(car.getPosition()).isEqualTo(0);

		car.goOrStop();
		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@Test
	@DisplayName("값은 똑같은 새로운 Car 객체를 복제한다.")
	void cloneTest() {
		Car car = new Car(new DefaultNumberGenerator(4));
		Car cloneCar = car.clone();

		car.goOrStop();

		assertThat(car).isNotEqualTo(cloneCar);
		assertThat(car.getPosition()).isNotEqualTo(cloneCar.getPosition());
	}

}
