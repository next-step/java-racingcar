package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.level3.model.strategy.RandomMovingStrategy;
import carRacing.level3.model.strategy.RandomNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomNumStrategyTest {

	RandomMovingStrategy movingStrategy = new RandomMovingStrategy();
	RandomNum randomNum = new RandomNum();

	@Test
	@DisplayName("randomNum()는 0~9까지의 랜덤값을 생성해준다")
	void getRandomNum() {
		assertThat(randomNum.randomNum()).isLessThan(10);
	}

	@ParameterizedTest
	@ValueSource(ints = {6, 7, 4})
	@DisplayName("isMoving()는 랜덤값이 4이상이면 True를 반환한다.")
	void isTrue(int value) {
		assertThat(movingStrategy.movingStrandard(value)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("랜덤값이 4 미만이면 false를 반환한다.")
	void isFalse(int value) {
		assertThat(movingStrategy.movingStrandard(value)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {-5, 10})
	@DisplayName("랜덤값이 0~10범위가 아니라면 false를 반환한다.")
	void 랜덤값_예외_테스트(int value) {
		assertThat(movingStrategy.movingStrandard(value)).isFalse();
	}

}