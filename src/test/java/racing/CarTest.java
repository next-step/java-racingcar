package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"", "  ", "123456"})
	@DisplayName("자동차 생성 테스트(name validate)")
	void test_prepareInitRacingCar(String name) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car(name);
		});
	}


	@Test
	@DisplayName("랜덤값이 4이상이면 전진한다.")
	void test_forward() {
		Car car = new Car();
		int inputNumber = 4;
		car.speedUp(inputNumber);
		assertThat(car.getForwardPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤값이 4보다 작으면 멈춘다.")
	void test_stop() {
		Car car = new Car();
		int inputNumber = 3;
		car.speedUp(inputNumber);
		assertThat(car.getForwardPosition()).isEqualTo(0);
	}

}