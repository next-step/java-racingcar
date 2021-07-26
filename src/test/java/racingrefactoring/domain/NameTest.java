package racingrefactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

	@Test
	@DisplayName("정상 이름 길이 테스트")
	void valid_name() throws Exception {
		//given
		String carName = "test";

		//when
		Name name = new Name(carName);

		//then
		assertThat(name.toString()).hasToString(carName);

	}

	@Test
	@DisplayName("비정상 이름 길이 테스트")
	void invalid_name() throws Exception {
		//given
		String carName = "long name test";

		//when, then
		assertThatThrownBy(() -> new Name(carName)).isInstanceOf(CarNameException.class)
		                                           .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");

	}


}