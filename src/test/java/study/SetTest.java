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
	@DisplayName("요구사항1, 크기 확인하기 테스트")
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("요구사항2, 갖고 있는 값 확인하기 테스트")
	@ValueSource(strings = {"1", "2", "3"})
	void contains(String input) {
		assertThat(numbers.contains(Integer.parseInt(input))).isTrue();
	}

	@ParameterizedTest
	@DisplayName("요구사항3, 파라메터 외부 주입 및 개별 성공, 실패 테스트")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void trueOrFalse(String input, String expected) {
		assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.parseBoolean(expected));
	}
}
