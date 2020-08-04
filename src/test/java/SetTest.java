import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	@DisplayName("요구사항 1 : set size 확인")
	public void test1() {
		assertThat(numbers.size()).isEqualTo(3);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("요구사항 2 : @ValueSource, parameterized 테스트")
	public void test2(int input) {
		assertThat(numbers).contains(input);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true","3:true","4:false","5:false"}, delimiter = ':')
	@DisplayName("요구사항 3 : @CsvSource, parameterized 테스트")
	public void test3(int input, boolean expected) {
		assertEquals(numbers.contains(input), expected);
	}
	
	
}
