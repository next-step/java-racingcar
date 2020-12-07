package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;
import racing.model.Forward;
import racing.model.Stop;

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
	@DisplayName("전진 테스트")
	void test_forward() {
		Car car = new Car("테스트카");
		car.speedUp(new Forward());
		assertThat(car.getForwardPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("멈춤 테스트")
	void test_stop() {
		Car car = new Car("테스트카");
		car.speedUp(new Stop());
		assertThat(car.getForwardPosition()).isEqualTo(0);
	}

}