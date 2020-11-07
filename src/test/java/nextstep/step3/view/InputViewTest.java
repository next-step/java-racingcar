package nextstep.step3.view;

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
	@DisplayName("자동차 레이싱게임 게임시도 횟 입력메시지 테스트")
	public void inputMessageTryNumberTest() {
		InputView underTest = new InputView(new Scanner("5"));
		Integer carNumber = underTest.getInputMessageTryNumber();
		assertThat(carNumber).isEqualTo(5);
	}
}
