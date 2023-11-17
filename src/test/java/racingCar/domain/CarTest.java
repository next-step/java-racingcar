package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.domain.Car;
import racingCar.domain.CarName;
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
	@DisplayName("생성자_생성자에 distance randomNumberSupplier, name 입력_name값이 있는 Car 객체 생성")
	void addCar(String input, String expected) {
		Car car = new Car(0, new RandomNumberSupplier(), new CarName(input));
		assertThat(car.carName.carName()).isEqualTo(expected);
	}

	@Test
	@DisplayName("생성자_name에 5자를 초과한 String 입력_throw RuntimeException")
	void addCarThrowException() {
		assertThatThrownBy(() -> {
			Car car = new Car(0, new RandomNumberSupplier(), new CarName("testName"));
		}).isInstanceOf(RuntimeException.class).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
	}

	@Test
	@DisplayName("maxDistance_경계값입력_더 큰 값 반환")
	void maxDistance() {
		Car car = new Car(3, new RandomNumberSupplier(), new CarName("test"));
		assertThat(car.maxDistance(2)).isEqualTo(3);
		assertThat(car.maxDistance(4)).isEqualTo(4);
	}

	@Test
	@DisplayName("matchMaxDistance_경계값입력_true / false")
	void matchMaxDistance() {
		Car car = new Car(3, new RandomNumberSupplier(), new CarName("test"));
		assertThat(car.matchMaxDistance(3)).isTrue();
		assertThat(car.matchMaxDistance(4)).isFalse();
	}
}
