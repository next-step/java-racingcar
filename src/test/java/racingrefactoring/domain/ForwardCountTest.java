package racingrefactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ForwardCountTest {

	@Test
	@DisplayName("이동 없음")
	void init() throws Exception {
		//given
		ForwardCount forwardCount = new ForwardCount();

		//when

		//then
		assertThat(forwardCount.isPositive()).isFalse();

	}

	@Test
	@DisplayName("이동 수 증가")
	void move_forward() throws Exception {
		//given
		ForwardCount forwardCount = new ForwardCount();

		//when
		forwardCount.increase();

		//then
		assertThat(forwardCount.isPositive()).isTrue();

	}

	@Test
	@DisplayName("이동 수를 음수로 생성")
	void wrong_init() throws Exception {
		//given

		//when

		//then
		assertThatThrownBy(() -> new ForwardCount(-1)).isInstanceOf(IllegalArgumentException.class);

	}

}
