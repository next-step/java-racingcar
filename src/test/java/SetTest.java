import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
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
	@DisplayName("Set 의 크기를 확인하는 테스트")
	public void sizeTest() {
		// when
		int size = numbers.size();

		// then
		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set 내 파라미터로 받은 값이 존재하는지 확인하는 테스트")
	public void containsTestWithValueSource(int number) {
		// when
		boolean isContainNumber = numbers.contains(number);

		// when
		assertThat(isContainNumber).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("Set 내 파라미터로 받은 값과 기대하는 결과가 일치하는지 테스트")
	public void containsTestWithCsvSource(int number, boolean expected) {
		// when
		boolean isContainNumber = numbers.contains(number);

		// when
		assertThat(isContainNumber).isEqualTo(expected);
	}
}
