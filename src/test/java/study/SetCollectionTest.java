package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	@Test
	void size() {
		int numbersSize = numbers.size();

		assertThat(numbersSize).isEqualTo(3);
	}

	@Test
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void parameterizedValueSource(Integer input) {
		assertTrue(numbers.contains(input));
	}

	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	void parameterizedCsvSource(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
