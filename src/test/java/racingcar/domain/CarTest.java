package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@Test
	@DisplayName("자동차 이름이 NULL 이면 IllegalArgumentException 을 throw 해야한다")
	void throwIllegalArgumentExceptionWhenNameNullTest() {
		assertThatThrownBy(() -> new Car(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름이 빈 문자열이면 IllegalArgumentException 을 throw 해야한다")
	void throwIllegalArgumentExceptionWhenNameEmptyTest() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 을 throw 해야한다")
	void throwIllegalArgumentExceptionWhenLongNameTest() {
		assertThatThrownBy(() -> new Car("long-name"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("입력값이 4 이상인 경우 moveCount 가 증가해야한다 ")
	void moveTest(int inputNumber) {
		Car car = new Car("abc");
		car.tryMove(inputNumber);
		assertThat(car.racingResult().getMoveCount()).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("입력값이 4 미만인 경우 moveCount 가 유지되어야한다 ")
	void stopTest(int inputNumber) {
		Car car = new Car("abc");
		car.tryMove(inputNumber);
		assertThat(car.racingResult().getMoveCount()).isEqualTo(0);
	}

	@Test
	@DisplayName("이동이 여러번 시도될 경우 moveCount 는 누적되어 증가해야한다 ")
	void moveRepeatTest() {
		Car car = new Car("abc");
		car.tryMove(4);
		assertThat(car.racingResult().getMoveCount()).isEqualTo(1);
		car.tryMove(5);
		assertThat(car.racingResult().getMoveCount()).isEqualTo(2);
		car.tryMove(2);
		assertThat(car.racingResult().getMoveCount()).isEqualTo(2);
		car.tryMove(9);
		assertThat(car.racingResult().getMoveCount()).isEqualTo(3);
	}
}
