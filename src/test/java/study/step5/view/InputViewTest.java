package study.step5.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.exception.BadRequestException;

class InputViewTest {
	InputView inputView = new InputView();

	@DisplayName("입력 가능한 글자수를 입력하면 예외를 던지지 않는다. ")
	@Test
	void Given_CarNameOver5_Then_NotThrowException() {
		assertDoesNotThrow(() -> inputView.validateName("abcd"));
	}

	@DisplayName("최대 입력 가능한 이름 글자 범위를 초과하면 예외를 던진다.")
	@Test
	void Given_NameOver5_Then_ThrowException() {
		assertThatThrownBy(() -> inputView.validateName("abcdefg")).isInstanceOf(BadRequestException.class);
	}

	@DisplayName("0을 입력하면 예외를 던지지 않는다.")
	@Test
	void Given_Zero_Then_NotThrowException() {
		assertDoesNotThrow(() -> inputView.validateRound(0));
	}

	@DisplayName("양수를 입력하면 예외를 던지지 않는다.")
	@Test
	void Given_UpperZero_Then_NotThrowException() {
		assertDoesNotThrow(() -> inputView.validateRound(1));
	}

	@DisplayName("음수를 입력하면 예외를 던진다.")
	@Test
	void Given_UnderZero_Then_ThrowException() {
		assertThatThrownBy(() -> inputView.validateRound(-1)).isInstanceOf(BadRequestException.class);
	}
}