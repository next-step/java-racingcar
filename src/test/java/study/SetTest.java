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
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	@DisplayName("Set의 크기를 구하는 테스트")
	@Test
	void size() {
		int number = 3;
		int size = numbers.size();
		assertThat(size).isEqualTo(number);
	}

	@DisplayName("특정 숫자가 존재하는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2})
	void vertifyExistence(int param) {
		assertTrue(numbers.contains(param));
	}

	@DisplayName("특정 숫자가 존재하는지 확인하는 테스트_BY_CSV")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "4:false"}, delimiter = ':')
	void vertifyExistenceByCsv(int target, boolean result) {
		boolean status = numbers.contains(target);
		assertThat(status).isEqualTo(result);
	}
}
