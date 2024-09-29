package step1;

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
	@DisplayName("Set.size() 에 대한 학습 테스트")
	void sizeMethodTest() {
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set.contains() 에 대한 학습 테스트")
	void containsMethodTest(int input) {
		assertThat(numbers).contains(input);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("containsMethodTest 에서 처리못하는 false에 대한 학습 테스트")
	void containsMethodTestWithFalse(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}
