package nextstep.step3.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

	@Test
	@DisplayName("자동차 레이싱게임 차 대수 입력메시지 테스트")
	public void inputMessageCarNumberTest() {
		InputView underTest = new InputView(new Scanner("5"));
		Integer carNumber = underTest.getInputMessageCarNumber();
		assertThat(carNumber).isEqualTo(5);
	}

	@Test
	@DisplayName("자동차 레이싱게임 게임시도 횟수 입력메시지 테스트")
	public void inputMessageTryNumberTest() {
		InputView underTest = new InputView(new Scanner("5"));
		Integer carNumber = underTest.getInputMessageTryNumber();
		assertThat(carNumber).isEqualTo(5);
	}

	@Test
	@DisplayName("자동차 레이싱게임 차와 시도횟수는 숫자만 입력가능하다. ")
	public void inputValidateNumberTest() {
		InputView underTest = new InputView(new Scanner("abc"));
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.getInputMessageCarNumber())
				.withMessage("자동차수와 시도횟수는 숫자만 가능합니다.");
	}
}
