package step1;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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

	@DisplayName("요구사항 1 - Set 크기 확인")
	@Test
	void checkSetSize() {
		// when
		int size = numbers.size();

		// then
		assertThat(size).isEqualTo(3);
	}

	@DisplayName("요구사항 2 - Set의 값 존재하는지 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void checkSetValue(int value) {
		assertThat(numbers.contains(value)).isTrue();
	}

	@DisplayName("요구사항 3 - Set의 값 존재하는지 존재하지 않는지 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void checkSetValueTrueFalse(int value, boolean expected) {
		assertThat(numbers.contains(value)).isEqualTo(expected);
	}

}
