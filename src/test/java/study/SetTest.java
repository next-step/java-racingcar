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

	@DisplayName(value = "Set의 크기 테스트")
	@Test
	void numbersSize() {
		int numbersSize = numbers.size();
		assertThat(numbersSize).isEqualTo(3);
	}


	@DisplayName(value = "Set에 값이 포함되는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int number) {
		boolean containsNumber = numbers.contains(number);
		assertThat(containsNumber).isTrue();
	}

	@DisplayName(value = "입력 값에 따라 Set에 포함되는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void containsInputValue(int input, boolean expected) {
		boolean containsNumber = numbers.contains(input);
		assertThat(containsNumber).isEqualTo(expected);
	}
}
