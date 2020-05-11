package step1;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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

	// 요구사항1
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	// 요구사항2
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	// 요구사항3
	@ParameterizedTest
	@CsvSource(value = { "1:true", "2:true", "3:true","4:false","5:false" }, delimiter = ':')
	void containsWithFail(int input, boolean expected) {
		assertEquals(expected, numbers.contains(input));
	}
}
