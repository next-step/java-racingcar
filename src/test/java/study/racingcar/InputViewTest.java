package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.view.InputView;

public class InputViewTest {

	ByteArrayInputStream bindData;

	private void provideInput(String data) {
		bindData = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
		System.setIn(bindData);
	}


	@Test
	@DisplayName("문자열 입력 후 숫자로 변환")
	void inputUserStringToInt(){
		String expected = "1";
		provideInput(expected);

		int inputUserCount = InputView.inputCarCountByUser();
		assertThat(inputUserCount).isEqualTo(1);
	}

	@Test
	@DisplayName("숫자가 아닌 값을 입력할 때 error 처리")
	void inputNotInteger(){
		String expected = "one";
		provideInput(expected);

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(InputView::inputCarCountByUser);
	}

	@Test
	@DisplayName("쉼표가 아닌 구분자로 입력할 경우")
	void inputCarNames(){
		String expected = "pobi:crong:honux";
		provideInput(expected);

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(InputView::inputCarNamesByUser);
	}

}
