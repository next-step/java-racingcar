package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.car.Car;
import racingCar.util.NumberSupplier;
import racingCar.util.RandomNumberSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	@ParameterizedTest
	@CsvSource({"3,0", "4,1"})
	@DisplayName("move_결과 0,1의 경계값 입력_0,1")
	void move(int input, int expected) {
		NumberSupplier numberSupplier = (new NumberSupplier() {
			@Override
			public int get() {
				return input;
			}
		});
		Car car = new Car(0, numberSupplier);
		car.move();
		assertThat(car.distance).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({"testN, testN"})
	@DisplayName("addCar_생성자에 distance randomNumberSupplier, name 입력_name값이 있는 Car 객체 생성")
	void addCar(String input, String expected) {
		Car car = new Car(0, new RandomNumberSupplier(), input);
		assertThat(car.name).isEqualTo(expected);
	}

	@Test
	@DisplayName("new Car(distance, RandomNumberSupplier, name)_name에 5자를 초과한 String 입력_throw RuntimeException")
	void addCarThrowException() {
		assertThatThrownBy(() -> {
			Car car = new Car(0, new RandomNumberSupplier(), "testName");
		}).isInstanceOf(RuntimeException.class).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
	}
}
