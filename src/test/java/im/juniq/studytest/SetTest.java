package im.juniq.studytest;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	@DisplayName("Set 크기를 확인한다")
	void testSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("ParameterrizedTest를 이용해 contain 메소드를 테스트한다")
	void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}


	@ParameterizedTest
	@CsvSource({"1, 4", "2, 5", "3, 6"})
	@DisplayName("contains 메소드 실행 결과가 false 인 경우를 테스트한다")
	void containsWithException(int numberOfTrue, int numberOfFalse) {
		assertThat(numbers.contains(numberOfTrue)).isTrue();
		assertThat(numbers.contains(numberOfFalse)).isFalse();
	}
}
