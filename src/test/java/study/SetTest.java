package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	// 요구사항 1
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
	public void size() {
		assertThat(numbers).hasSize(3);
		assertThat(numbers.isEmpty()).isFalse();
	}
	
//	@Test
//  void contains() {
//      assertThat(numbers.contains(1)).isTrue();
//      assertThat(numbers.contains(2)).isTrue();
//      assertThat(numbers.contains(3)).isTrue();
//  }
	
//	@ParameterizedTest
//	@ValueSource(ints = {1, 2, 3})
//	void contains(int number) {
//	    assertThat(numbers.contains(number)).isTrue();
//	}
	
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:false"}, delimiter = ':')
	void contains(int number, boolean result) {
		assertThat(numbers.contains(number)).isEqualTo(result);
	}
}