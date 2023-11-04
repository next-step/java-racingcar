package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("size()메소드를 통해 크기를 확인한다")
	@Test
	void checkSize() {
		assertThat(numbers).hasSize(3);
	}

	@DisplayName("contains()메소드를 통해 값이 존재하는지 확인한다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void checkContains(int targetNumber) {
		assertThat(numbers.contains(targetNumber)).isTrue();
	}

	@DisplayName("contains 메소드의 결과가 다른 경우")
	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	void checkContains2(int targetNumbers, boolean expectedResult) {
		assertThat(numbers.contains(targetNumbers)).isEqualTo(expectedResult);
	}
}