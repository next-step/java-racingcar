package edu.nextstep.racing.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputView : 사용자 입력 UI 로직을 담당하는 View 클래스")
class InputViewTest {

	@DisplayName("isValidInput : 입력된 문자열이 쉼표로 구분되는 최대 다섯글자의 공백이 아닌 패턴을 만족하면 true를 리턴")
	@ParameterizedTest
	@ValueSource(strings = {"53fg", "가나a,2144,dh4", "가,나,abc", "!@#$%,^&*(),_+=|,<>/?',;:\""})
	void isValidInput_ShouldTrue(String input) {
		assertThat(InputView.isValidInput(input)).isTrue();
	}

	@DisplayName("isValidInput : 입력된 문자열이 쉼표로 구분되는 최대 다섯글자의 공백이 아닌 패턴을 만족하지 못하면 false를 리턴")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {",", ",,", "d,gga33d,sdfe", ",,3357,", "abc-,,d"})
	void isValidInput_ShouldFalse(String input) {
		assertThat(InputView.isValidInput(input)).isFalse();
	}
}