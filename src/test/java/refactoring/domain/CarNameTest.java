package refactoring.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

	private static final int MAX_NAME_LENGTH = 5;
	private CarName carName;

	@Test
	@DisplayName("CarName 객체 생성 성공")
	void createCarNameSuccess() {
		carName = new CarName("test");

		assertThat(carName.getName()).isEqualTo("test");
	}

	@Test
	@DisplayName("CarName 객체 생성 실패 5글자 초과")
	void createCarNameFailure() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> carName = new CarName("wefqwfdddddqwfqwf"))
			.withMessageMatching("자동차 이름은 " + MAX_NAME_LENGTH + "자 이상 초과할 수 없습니다.");
	}

	@Test
	@DisplayName("CarName 객체 생성 실패 빈값")
	void createCarNameFailure2() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> carName = new CarName(""))
			.withMessageMatching("자동차 이름은 공백일 수 없습니다.");
	}
}