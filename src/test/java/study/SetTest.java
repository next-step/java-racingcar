package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
	Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	void numbers변수의_크기가_3인지_확인한다() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void 입력값이_주어졌을_때_그_값이_포함되는지를_확인한다(int intValue) {
		assertTrue(numbers.contains(intValue));
	}

	@ParameterizedTest
	@CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void 입력값과_기대값이_주어졌을_때_contains함수의_조건을_만족하는지_테스트한다(int input, boolean expected) {
		assertEquals(numbers.contains(input), expected);
	}
}
