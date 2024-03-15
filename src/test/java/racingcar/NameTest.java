package racingcar;

import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {
	@DisplayName("자동차 이름이 5글자가 초과될 경우 예외를 던진다.")
	@Test
	void nameToCarOverFiveNumberOfCharacters () {
		// given & when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					new Name("mercedes");
				}).withMessageMatching("글자수가 5를 초과했습니다. 다시 입력해주세요.");
	}
}
