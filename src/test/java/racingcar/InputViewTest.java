package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {
	@DisplayName("쉼표를 포함한 자동차 이름을 입력받아 쉼표를 기준으로 자동차 이름을 분리한다.")
	@Test
	void inputCarNamesIncludingCommas() {
		// given
		String input = "hyundai,samsung,kia";

		// when
		String[] result = InputView.inputCarNames(input);

		// then
		assertThat(result).containsExactly("hyundai", "samsung", "kia");
	}
}
