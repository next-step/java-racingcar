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
	@DisplayName("Set의 size()로 Set의 크기를 확인한다.")
	void Given_Set_When_Size_Then_ReturnSetSize(){

		// when
		int result = numbers.size();

		// then
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void Given_Set_When_Contains_Then_ReturnTrue(int value){

		// when
		boolean result = numbers.contains(value);

		// then
		assertThat(result).isEqualTo(true);
	}

	@DisplayName("Set의 contains() 메소드를 활용해 존재하는 값은 true, 존재하지 않으면 false를 반환한다")
	@ParameterizedTest
	@CsvSource(value = {
		"1:true",
		"2:true",
		"3:true",
		"4:false",
		"5:false"
	},
		delimiter = ':')
	void Given_Set_When_Contains_Then_ReturnTrueAndFalse(int value, boolean hasValue){

		// when
		boolean result = numbers.contains(value);

		// then
		assertThat(result).isEqualTo(hasValue);
	}
}
