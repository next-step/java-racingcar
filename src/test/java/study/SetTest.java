package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection 학습")
public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	// Test Case 구현
	@Test
	@DisplayName("set 크기 확인")
	void setSize() {
		int size = numbers.size();
		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("number set에 1,2,3의 값이 존재하는지 확인.")
	void isContainsNum(int num) {
		assertThat(numbers.contains(num)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("CsvSource로 1,2,3은 true, 4,5는 false 판별")
	void isContainNumInSetByCsvSource(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("study.SetTest#provideIntForIsExistInSet")
	@DisplayName("MethodSource로 1,2,3은 true, 4,5는 false 판별")
	void isContainNumInSetByMethodSource(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}

	static Stream<Arguments> provideIntForIsExistInSet() {
		return Stream.of(
			Arguments.of(1, true),
			Arguments.of(2, true),
			Arguments.of(3, true),
			Arguments.of(4, false),
			Arguments.of(5, false)
		);
	}
}

