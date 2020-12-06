package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

	Car car = new Car();

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
	@DisplayName("랜덤값이 4이상인 경우 한 칸 전진한다.")
	void test_forward() {
		assertThat(car.isForward(4)).isTrue();
		assertThat(car.isForward(0)).isFalse();
		assertThat(car.isForward(-1)).isFalse();
	}

}