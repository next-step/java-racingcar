package step1;

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
	@DisplayName("Set size()는 Set 원소 개수를 반환한다")
	public void test1(){
		int expected = 3;

		int result = numbers.size();

		Assertions.assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("Set에 원소가 들어가 있다 contains")
	public void test2(){
		Assertions.assertThat(numbers.contains(1)).isTrue();
		Assertions.assertThat(numbers.contains(2)).isTrue();
		Assertions.assertThat(numbers.contains(3)).isTrue();
	}

	@DisplayName("Set에 원소가 들어가 있다 contains")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void test3(int input){
		Assertions.assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("Set에 원소가 들어가 있다 contains")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "4:false"}, delimiter = ':')
	public void test3(int input, boolean expected){
		Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
