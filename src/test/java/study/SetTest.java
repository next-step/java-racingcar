package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("[요구사항 1] Set의 크기 확인 테스트")
	public void getSize() {
		//when
		int actual = numbers.size();

		//then
		assertThat(actual).isEqualTo(3);
	}

	@ParameterizedTest(name = "[요구사항 2] 값이 존재하는지 테스트 - 값: {0}")
	@ValueSource(ints = {1, 2, 3})
	public void containValues(int value) {
		//when
		boolean actual = numbers.contains(value);

		//then
		assertThat(actual).isTrue();
	}

	@ParameterizedTest(name = "[요구사항 3] 입력값과 결과값 테스트 - 값: {0}, expected: {1}")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	public void containValuesException(int value, boolean expected) {
		//when
		boolean actual = numbers.contains(value);

		//then
		assertThat(actual).isEqualTo(expected);
	}
}
