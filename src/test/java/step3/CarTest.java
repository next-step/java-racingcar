package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
	@ParameterizedTest
	@CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
	void isGoTest(int input, boolean expected) {
		Car car = new Car(new RandomNumberGenerator());
		assertThat(car.isGo(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0", "3,0", "4,1", "9,1"})
	void goOrStopTest(int input, int expected) {
		Car car = new Car(new DefaultNumberGenerator(input));
		assertThat(car.getPosition()).isEqualTo(0);

		car.goOrStop();
		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@Test
	void cloneTest() {
		Car car = new Car(new DefaultNumberGenerator(4));
		Car cloneCar = car.clone();

		car.goOrStop();

		assertThat(car).isNotEqualTo(cloneCar);
		assertThat(car.getPosition()).isNotEqualTo(cloneCar.getPosition());
	}

}
