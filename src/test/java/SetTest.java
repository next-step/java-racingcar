import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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

	@DisplayName("요구사항 1")
	@Test
	void size() {
		int size = numbers.size();
		assertThat(size).isEqualTo(3);
	}

	@DisplayName("요구사항 2")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("요구사항 3")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false",}, delimiter = ':')
	void test(String input, String expected) {
		int number = Integer.parseInt(input);
		boolean isExist = Boolean.parseBoolean(expected);
		assertThat(numbers.contains(number)).isEqualTo(isExist);
	}

}
