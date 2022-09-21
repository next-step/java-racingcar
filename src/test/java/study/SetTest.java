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

	@Test
	@DisplayName("Set 크기")
	void size() {
		int size = numbers.size();
		assertThat(size).isEqualTo(3);
	}

	@DisplayName("원소 포함")
	@ParameterizedTest(name = "정수 {0}")
	@ValueSource(ints = {1, 2, 3})
	void contains(int element) {
		assertThat(numbers.contains(element)).isTrue();
	}

	@DisplayName("원소 포함 여부")
	@ParameterizedTest(name = "정수 {0}")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains(int element, boolean expected) {
		assertThat(numbers.contains(element)).isEqualTo(expected);
	}
}
