package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutomobileRaceTest {


	@DisplayName("스프링에 - 을 이어붙일 때 나오는 결과를 테스트")
	@Test
	void StringAddTest() {
		String str = "";
		String result = "" + "-";
		assertThat("-").isEqualTo(result);
	}
}
