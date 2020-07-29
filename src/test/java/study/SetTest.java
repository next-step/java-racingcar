package study;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	public void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "3:false", "4:true"}, delimiter = ':')
	public void contains2(int number, boolean result) {
		assertThat(numbers.contains(number)).isEqualTo(result);
	}

	@Test
	public void size() {
		assertThat(numbers).hasSize(3);
		assertThat(numbers.size()).isEqualTo(2);
		assertThat(numbers.isEmpty()).isFalse();
	}
}
