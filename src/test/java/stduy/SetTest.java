package stduy;

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
	public void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("Set 의 size() 메소드 를 활용해 set 의 크기 확인")
	public void validSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set 의 contains() 메소드를 활용해 1,2,3의 값 존재 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void checkDataExistence(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("Set 의 contains() 메소드 활용해 true 및 false 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	public void checkDataContains(int number, boolean result) {
		assertThat(numbers.contains(number)).isEqualTo(result);
	}
}
