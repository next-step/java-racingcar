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

class CarTest {
	static final int MIN_MOVE_VALUE = 4;
	static final int MAX_BOUND = 10;

	static MockedStatic<RandomNumberGenerator> generator;

	@BeforeAll
	static void setUp() {
		generator = mockStatic(RandomNumberGenerator.class);
	}

	@ParameterizedTest(name = "랜덤값: {0}, 기대값: {1}")
	@MethodSource("goTestData")
	@DisplayName("자동차는 MIN_MOVE_VALUE(=4) 이상이면 car의 distance를 1 증가한다.")
	void goTest(int randomNumber, boolean expected) {
		// given
		Car car = new Car();
		when(RandomNumberGenerator.generateRandomNumber()).thenReturn(randomNumber);

		// when
		car.go();

		// then
		Assertions.assertEquals(car.getDistance(), expected ? 1 : 0);
	}

	static Stream<Arguments> goTestData() {
		return IntStream.range(0, MAX_BOUND)
			.mapToObj(i -> Arguments.of(i, i >= MIN_MOVE_VALUE));
	}

}
