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

@DisplayName("Set 테스트")
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
	@DisplayName("Set 사이즈 테스트")
	public void sizeTest() {
		assertThat(numbers).hasSize(3);
		assertThat(numbers.isEmpty()).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set에 주어진 값이 있는지 테스트")
	public void containsTestWithValueSource(int value) {
		assertThat(numbers.contains(value)).isTrue();
	}


	@ParameterizedTest
	@CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':')
	@DisplayName("Set에 주어진 값이 있는 경우와 없는 경 모두 테스트")
	public void containsTestWithCsvSource(int number, boolean result) {
		assertThat(numbers.contains(number)).isEqualTo(result);
	}
}
