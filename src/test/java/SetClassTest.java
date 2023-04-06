import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetClassTest {
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
	void setSizeCheck() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void setContains(int parameters) {
		assertThat(numbers.contains(parameters)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter =  ':')
	void setContainsTestWithCsvSource(int intParameter, boolean expected) {
		assertThat(numbers.contains(intParameter)).isEqualTo(expected);
	}
}
