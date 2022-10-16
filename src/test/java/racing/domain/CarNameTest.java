package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.exception.ErrorMessage;
import racing.exception.InvalidCarNameLengthException;

public class CarNameTest {

	private static final String SUCCESS_CAR_NAME = "CNAME";
	private static final String FAIL_CAR_NAME = "FALLIN";

	@DisplayName("정상 차 이름 성공 테스트")
	@Test
	void SuccessCarNameTest() {
		assertThatCode(() -> {
			CarName carName = new CarName(SUCCESS_CAR_NAME);
		}).doesNotThrowAnyException();
	}

	@DisplayName("정상 차 이름 예외 테스트")
	@Test
	void FailCarNameTest() {
		assertThatThrownBy(() -> {
			CarName carName = new CarName(FAIL_CAR_NAME);
		}).isInstanceOf(InvalidCarNameLengthException.class)
			.hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_LENGTH.getErrorMessage());
	}
}
