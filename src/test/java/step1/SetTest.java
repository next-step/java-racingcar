
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
	public void Set_크기_확인() throws Exception {
		assertThat(numbers).hasSize(3);
	}

	@Test
	public void Set_가지고_있는_수_확인() throws Exception {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1:true",
		"2:true",
		"3:true",
		"4:false",
		"5:false"
	}, delimiter = ':')
	public void Set_가지고_있는_수_true_false(int input, boolean expected) throws Exception {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
