package racingcar;

import static org.mockito.Mockito.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

import racingcar.domain.RandomMovingStrategy;
import racingcar.domain.RandomNumberGenerator;

class RandomMovingStrategyTest {
	static final int MIN_MOVE_VALUE = 4;
	static final int MAX_BOUND = 10;

	static MockedStatic<RandomNumberGenerator> generator;

	@BeforeAll
	static void setUp() {
		generator = mockStatic(RandomNumberGenerator.class);
	}

	@ParameterizedTest(name = "랜덤값: {0}, 기대값: {1}")
	@MethodSource("canGoData")
	@DisplayName("랜덤값이 MIN_MOVE_VALUE(=4) 이상이면 true를 반환하고 그렇지 않으면 false를 반환한다.")
	void goTest(int randomNumber, boolean expected) {
		// given
		RandomMovingStrategy movingStrategy = new RandomMovingStrategy();
		when(RandomNumberGenerator.generateRandomNumber()).thenReturn(randomNumber);

		// when
		boolean result = movingStrategy.canGo();

		// then
		Assertions.assertEquals(result, expected);
	}

	static Stream<Arguments> canGoData() {
		return IntStream.range(0, MAX_BOUND)
			.mapToObj(i -> Arguments.of(i, i >= MIN_MOVE_VALUE));
	}

}
