package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Random 클래스에 대한 학습 테스트")
public class RandomTest {

	@DisplayName("0~9 사이에서 랜덤값을 구한다.")
	@Test
	void nextInt() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			int randomValue = random.nextInt(10);
			assertThat(randomValue).isBetween(0, 9);
		}
	}
}
