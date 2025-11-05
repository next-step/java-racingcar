package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

	@Test
	@DisplayName("size()를 통해 Set의 크기를 확인할 수 있다")
	void size() {
		// Act
		int size = numbers.size();

		// Assert
		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("contains()를 통해 1, 2, 3의 값이 존재하는지를 확인할 수 있다")
	void contains(
		int value
	) {
		// Act
		boolean contains = numbers.contains(value);

		// Assert
		assertThat(contains).isTrue();
	}

	@ParameterizedTest
	@CsvSource({
		"1, true",
		"2, true",
		"3, true",
		"4, false",
		"5, false"
	})
	@DisplayName("contains()를 통해 존재하는 값과 존재하지 않는 값을 확인할 수 있다")
	void containsVariousValues(
		int value,
		boolean expected
	) {
		// Act
		boolean contains = numbers.contains(value);

		// Assert
		assertThat(contains).isEqualTo(expected);
	}
}
