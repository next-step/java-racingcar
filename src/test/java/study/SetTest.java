package study;

import org.junit.jupiter.api.BeforeEach;
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

	@Test
	void size() {
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3}) // 아래 애노테이션에 지정한 값이 메서드의 인자로 순차적으로 들어간다.
	void contains(int no) {
//		assertThat(numbers.contains(1)).isTrue();
//		assertThat(numbers.contains(2)).isTrue();
//		assertThat(numbers.contains(3)).isTrue();
		assertThat(numbers.contains(no)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "4:false"}, delimiter = ':') // 인자와 그 결과를 넣어줄 수 있다.
	void contains2(int no, boolean result) {
		assertThat(numbers.contains(no)).isEqualTo(result);
	}
}
