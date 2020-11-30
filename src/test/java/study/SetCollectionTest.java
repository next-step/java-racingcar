package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SetCollectionTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set의 크기를 확인한다.")
	@Test
	void shouldEqualsSetSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set의 값이 존재하는지 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void shouldExistContainNumber(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void shouldEqualsExpectedBooleanResult(int input, boolean expected) {
		assertEquals(expected, numbers.contains(input));
	}
}
