package study.racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Name;

class InputViewTest {
	@Test
	@DisplayName("String 을 List<Name>으로 변경")
	void convertNameList() {
		List<Name> names = InputView.stringIntoNameList("a,b,c");
		assertThat(names).contains(new Name("a"), new Name("b"), new Name("c"));
	}
}