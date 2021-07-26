package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

	private Racing racing;

	@BeforeEach
	void init() {
		String[] names = {"test", "test2", "test3"};

		racing = new Racing(names);
	}

	@Test
	@DisplayName("움직임이 없을때 모든 자동차가 우승으로 나와야 됨")
	void getTopRankResult() {
		assertThat(racing.getTopRankResult()).isEqualTo("test,test2,test3");
	}

	@Test
	@DisplayName("움직임이 없을때 모든 자동차가 우승으로 나와야 됨 실패케이스")
	void failGetTopRankResult() {
		assertThat(racing.getTopRankResult()).isNotEqualTo("test,test3");
	}
}