package study.collections;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
	@DisplayName("size 메서드는 컬랙션의 길이를 반환한다.")
	void test_size() {
		int expect = 3;
		int result = numbers.size();

		assertThat(result).isEqualTo(expect);
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	@DisplayName("contains 메서드는 컬랙션 안에 인자의 포함여부를 반환한다.")
	void test_contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@Test
	@DisplayName("contains 메서드는 인자로 컬랙션 안에 없는 값을 넘길 경우, 실패한다.)")
	void test_contains_fail() {
		int noContainedValue = 1000;

		assertThat(numbers.contains(noContainedValue)).isFalse();
	}

}
