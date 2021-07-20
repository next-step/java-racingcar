package training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("요구사항 1")
	void size() throws Exception {
		//then
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest(name = "[요구사항 2-{index}] {arguments}")
	@MethodSource
	@DisplayName("요구사항 2")
	void contains(int i) throws Exception {
		//then
		assertThat(numbers).contains(i);
	}

	public static Stream<Arguments> contains() {
		return Stream.of(
				Arguments.of(1),
				Arguments.of(2),
				Arguments.of(3)
		);
	}

	@ParameterizedTest(name = "[요구사항 3-{index}] {arguments}")
	@MethodSource
	@DisplayName("요구사항 3")
	void containsBoolean(int i, boolean expected) throws Exception {
		//then
		assertThat(numbers.contains(i)).isEqualTo(expected);
	}

	public static Stream<Arguments> containsBoolean() {
		return Stream.of(
				Arguments.of(1, true),
				Arguments.of(2, true),
				Arguments.of(3, true),
				Arguments.of(4, false),
				Arguments.of(5, false)
		);
	}
}
