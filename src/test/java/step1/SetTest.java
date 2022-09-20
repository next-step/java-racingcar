
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
	@DisplayName("Set 크기 확인")
	public void 요구사항1() throws Exception {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("Set 가지고 있는 수 확인")
	public void 요구사항2() throws Exception {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("Set 가지고 있는 수 확인(중복제거)")
	@ValueSource(ints = {1,2,3})
	public void 요구사항3(int input) throws Exception {
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("Set 가지고 있지 않은 수 확인(중복제거)")
	@ValueSource(ints = {4,5})
	public void 요구사항4(int input) throws Exception {
		assertThat(numbers.contains(input)).isFalse();
	}

	@ParameterizedTest
	@DisplayName("Set 가지고 있는 수 true, false 둘 다 확인(중복제거)")
	@CsvSource(value = {
		"1:true",
		"2:true",
		"3:true",
		"4:false",
		"5:false"
	}, delimiter = ':')
	public void 요구사항5(int input, boolean expected) throws Exception {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
