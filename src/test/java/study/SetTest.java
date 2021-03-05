package study;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
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
	@DisplayName("Set size() 테스트")
	void sizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set contains() 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void containsTest(int inputNumber) {
		assertTrue(numbers.contains(inputNumber));
	}

	@DisplayName("Parameterized true/false 반환값 테스트")
	@ParameterizedTest
	@CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false" }, delimiter = ':')
	void containsTrueFalseTest(int inputNumber, boolean expected) {
		assertEquals(numbers.contains(inputNumber), expected);
	}
}
