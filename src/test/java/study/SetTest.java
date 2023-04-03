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
	@DisplayName("Set의 size 메서드를 테스트")
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 contains 메서드를 테스트")
	void contains(int key) {
		assertThat(numbers.contains(key)).isTrue();
	}

	@ParameterizedTest
	@CsvSource({ "1,true", "-1,false", "0,false" })
	void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int key, boolean expected) {
		assertThat(numbers.contains(key)).isEqualTo(expected);
	}
}
