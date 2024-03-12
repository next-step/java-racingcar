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

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetTest {
	private Set<Integer> numbers = new HashSet<>();

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}


	@Test
	@DisplayName("size() 메소드를 통해 크기를 확인할 수 있다.")
	void getSize() {
		assertThat(numbers).hasSize(3);
	}

	@ParameterizedTest
	@DisplayName("주어진 값을 모두 담고 있다.")
	@ValueSource(ints = {1, 2, 3})
	void containsElement(int element) {
		assertThat(numbers).contains(element);
	}

	@DisplayName("주어진 값을 담고 있지 않다.")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void notContainsElement(int element, boolean expected) {
		assertThat(numbers.contains(element)).isEqualTo(expected);
	}
}
