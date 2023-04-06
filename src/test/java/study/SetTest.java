package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	@DisplayName("Set 의 size 메서드를 테스트")
	void size() {
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest(name = "key 가 {index} 일 때, Set 의 contains 메서드를 테스트")
	@CsvSource({ "1,true", "-1,false", "0,false" })
	void contains(int key, boolean expected) {
		assertThat(numbers.contains(key)).isEqualTo(expected);
	}
}
