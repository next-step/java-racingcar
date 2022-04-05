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

	@DisplayName("Set의 size() 로 크기 확인")
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("1,2,3 이 각각 존재하는지 확인 (@ValueSource 활용)")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("1,2,3 이 각각 존재하는지 확인 (@CsvSource 활용)")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains(int input, boolean expected) {

		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
