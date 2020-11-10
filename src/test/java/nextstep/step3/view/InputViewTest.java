package nextstep.step3.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

	@Test
	@DisplayName("자동차 레이싱게임 차 이름 입력메시지 테스트")
	public void inputMessageCarNammeTest() {
		InputView underTest = new InputView(new Scanner("adel,joy"));
		String carNames = underTest.getInputMessageCarName();
		assertThat(carNames).isEqualTo("adel,joy");
	}

	@Test
	@DisplayName("자동차 레이싱게임 게임시도 횟수 입력메시지 테스트")
	public void inputMessageTryNumberTest() {
		InputView underTest = new InputView(new Scanner("5"));
		Integer carNumber = underTest.getInputMessageTryNumber();
		assertThat(carNumber).isEqualTo(5);
	}

	@Test
	@DisplayName("자동차 레이싱게임 차이름은 비어있으면 안된다.")
	public void inputValidateCarNameTest() {
		InputView underTest = new InputView(new Scanner(""));
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.getInputMessageCarName())
				.withMessage("자동차 이름은 필수입니다.");
	}
}
