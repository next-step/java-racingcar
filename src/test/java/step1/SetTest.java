package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection에 대한 학습 테스트")
class SetTest {

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
	@DisplayName("Set의 size 테스트")
	void sizeTest() {
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest(name = "[{displayName}] input: {0}")
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 contains 테스트 - ValueSource")
	void containsTest(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest(name = "[{displayName}] input: {0} / expectResult: {1}")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("Set의 contains 테스트 - CsvSource")
	void containsTest(int input, boolean expectResult) {
		assertThat(numbers.contains(input)).isEqualTo(expectResult);
	}

}
