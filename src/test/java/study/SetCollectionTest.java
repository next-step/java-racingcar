package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetCollectionTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("요구사항 1 - Set의 크기 확인")
	@Test
	void checkSetSize() {
		// when
		int size = numbers.size();
		// then
		assertThat(size).isEqualTo(3);
	}

	@DisplayName("요구사항 2 - Set의 값 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void checkSetValue(int input) {
		// then
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("요구사항 3 - Set의 값이 들어있는 경우와 값이 들어있지 않은 경우")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void testMethodNameHere(int input, boolean expected) {
		// then
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
