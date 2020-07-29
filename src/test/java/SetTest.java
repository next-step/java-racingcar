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

	// Test Case 구현

	@DisplayName("numbers set 크기 확인")
	@Test
	void size() {
		//when, then
		assertEquals(3, numbers.size());
	}

	@DisplayName("numbers set 저장값 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int value) {
		//when, then
		assertThat(numbers.contains(value)).isTrue();
	}

	@DisplayName("numbers set 값 저장여부 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
	void containsOrNot(int value, boolean expected) {
		//when, then
		assertThat(numbers.contains(value)).isEqualTo(expected);
	}
}
