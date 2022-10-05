package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.level3.model.strategy.RandomNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumStrategyTest {
	RandomNum randomNum = new RandomNum();

	@Test
	@DisplayName("randomNum()는 0~9까지의 랜덤값을 생성해준다")
	void getRandomNum() {
		assertThat(randomNum.randomNum()).isLessThan(10);
	}

}