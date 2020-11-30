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
import static org.junit.jupiter.api.Assertions.*;

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
	@DisplayName("요구사항 1. Set 사이즈 체크")
	void checkSetSize() {
		assertEquals(numbers.size(), 3);
	}

	@Test
	@DisplayName("요구사항 2. set에 특정 값 존재 체크")
	void hasValue_InSet() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("요구사항 2. ParameterizedTest 활용하여 set에 특정 값 존재 체크")
	void hasValue_InSet_UsingParameterizedTest(Integer input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("요구사항 3. 1,2,3이 들어있으면 True, 4,5가 들어있으면 False 확인하는 테스트")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false",}, delimiter = ':')
	void test_hasValue_notHasValue(Integer input, Boolean expected) {
		assertEquals(expected, numbers.contains(input));
	}
}
