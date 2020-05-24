package study3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

	@Test
	@DisplayName("랜덤생성 테스트")
	void randomGenerateTest() {
		RandomGenerator rg = new RandomGenerator();
		
		int a = rg.randomGenerate();
		assertThat(a).isLessThan(10); // 이부분에서 10대신 9로하면 fail이 되는 경우가 있는데요
										// 이부분에 대한 좋은 해결책 있으면 알려주시면 감사하겠습니다.
	}

}
