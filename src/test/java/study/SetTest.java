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

/**
 * Set Collection에 대한 학습 테스트
 */

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

	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기 확인")
	@Test
	void size() {
		assertThat(numbers).hasSize(3);
	}

	@DisplayName("Set의 contains() 메소드를 활용해 값이 존재하는지 확인, @ParameterizedTest 활용")
	@ValueSource(ints = {1, 2, 3})
	@ParameterizedTest
	void contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("Set의 contains() 메소드를 활용해 값이 존재하는지 존재하지 않는지 확인, @ParameterizedTest 활용")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@ParameterizedTest
	void contains(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
