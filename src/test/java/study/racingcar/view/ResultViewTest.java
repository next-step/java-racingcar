package study.racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Name;

class ResultViewTest {
	@Test
	@DisplayName("우승자리스트(List<Name>)에 콤마 찍기")
	void winners() {

		String winners = ResultView.winners(Arrays.asList(new Name("pobi"), new Name("alex")));

		assertThat(winners).isEqualTo("pobi, alex");

	}
}