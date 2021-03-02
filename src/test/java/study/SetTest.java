package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private static Set<Integer> numbers;

	@BeforeAll
	static void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("set size check")
	void 요구사항1() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("parameterizedTest를 이용하여 파라미터에 데이터들어가는지 확인")
	void 요구사항_2(int param) {
		assertThat(numbers.contains(param));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("delimeter 기준으로 자른 input과 expected를 parameter로 받아 numbers에 있는지 체크")
	void 요구사항_3(String input, String expected) {
		int number = Integer.parseInt(input);
		assertEquals(numbers.contains(number), Boolean.parseBoolean(expected));
	}
}
