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

class SetTest {

	private Set<Integer> numbers;

	@SuppressWarnings("OverwrittenKey")
	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		// 의도된 duplicated add()
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("요구사항 1. Set.size() 메소드를 활용해 Set 의 크기를 확인하는 학습 테스트")
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("요구사항 2. Set.contains() 테스트")
	void contains1(int value) {
		assertThat(numbers).contains(value);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("요구사항 3. Set.contains() 메소드 결과의 true 와 false 둘 다 검증하는 테스트")
	void contains2(int value, boolean result) {
		assertThat(numbers.contains(value)).isEqualTo(result);
	}
}
