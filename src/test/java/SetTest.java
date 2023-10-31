import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
	@Test
	public void getSize(){
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	public void testContains(){
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	public void testContainsWithParam(int number){
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
	public void testContainsWithCsvSource(int number, Boolean expectedResult){
		Boolean actualResult = numbers.contains(number);
		assertThat(expectedResult).isEqualTo(actualResult);
	}
}
