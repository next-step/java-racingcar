package study.step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JavaRacingcarSimpleTest {

	final JavaRacingcarSimple javaRacingcarSimple = new JavaRacingcarSimple();

	@DisplayName("random 값이 4 이상인 경우 true 를 반환한다")
	@Test
	void Given_MoreThen4_Then_ReturnTrue() {
		boolean result = javaRacingcarSimple.isGoForward(4);
		assertThat(result).isTrue();
	}

	@DisplayName("random 값이 4 미만인 경우 false 를 반환한다")
	@Test
	void Given_Under4_Then_ReturnFalse() {
		boolean result = javaRacingcarSimple.isGoForward(3);
		assertThat(result).isFalse();
	}
}