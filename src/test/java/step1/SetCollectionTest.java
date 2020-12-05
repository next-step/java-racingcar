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
public class SetCollectionTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("size : set의 크기를 확인함")
	@Test
	void requireOne() {
		int result = numbers.size();
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("contains : 1, 2, 3의 값이 존재하는지를 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void requireTwo(int input) {
		boolean result = numbers.contains(input);
		assertThat(result).isTrue();
	}

	@DisplayName("contains : 1, 2, 3, 4, 5의 값이 존재하는지를 확인했을 때 올바른 결과가 나옴")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void requireThree(int input, boolean expected) {
		boolean result = numbers.contains(input);
		assertThat(result).isEqualTo(expected);
	}

}
