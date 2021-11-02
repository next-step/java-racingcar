import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectTest {

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
	void step1() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void step2_AssertJ_사용(int setNumbers) {
		assertThat(numbers).contains(setNumbers);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void step2_Junit_사용(int setNumbers) {
		assertTrue(numbers.contains(setNumbers));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void step3_numbers에_값이_들어있는_경우(int setNumbers, boolean expected) {
		boolean actualResult = numbers.contains(setNumbers);

		assertThat(actualResult).isEqualTo(expected);
	}
}
