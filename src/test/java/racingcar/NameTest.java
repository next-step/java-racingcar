package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.racingcar.entity.Name;

public class NameTest {
	@ParameterizedTest
	@DisplayName("이름 5자 초과")
	@ValueSource(strings = {"abcdeff", "abcdeffff", "feffffeff", "안녕하십니까"})
	void 이름_다섯자_이상(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Name(input))
			.withMessageMatching("자동차 이름은 5자 이내입니다.");
	}

	@Test
	@DisplayName("null or 빈문자열 체크")
	void 빈_문자열인경우_excpetion() {
		assertAll(
			() -> assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new Name(""))
				.withMessageMatching("자동차 이름은 빈값은 불가합니다."),
			() -> assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new Name(null))
				.withMessageMatching("자동차 이름은 빈값은 불가합니다.")
		);
	}

	@ParameterizedTest
	@DisplayName("이름 성공 케이스 5자 이내")
	@ValueSource(strings = {"abcd", "abcde", "fe", "안녕하"})
	void 이름_성공_케이스(String input) {

		assertThat(new Name(input).toString())
			.isEqualTo(input);
	}
}
