package nextstep.step1;

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
	@DisplayName("요구사항 1 Set의 크기 확인 테스트")
	public void sizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("요구사항 2 contains와  @ParameterizedTest 사용하여 테스트")
	void setContainsTest(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
	@DisplayName("요구사항 3 contains와 @CsvSource 사용하여 테스트")
	void setContainsTestWithCsvSource(int actual, boolean expected) {
		assertThat(numbers.contains(actual)).isEqualTo(expected);
	}
}
