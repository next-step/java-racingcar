import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set 클래스에 대한 학습 테스트")
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


	@Nested
	@DisplayName("요구사항 1")
	class Requirement1Test {
		@Test
		@DisplayName("Set 의 size() 메소드를 활용해 Set 의 크기를 확인")
		void sizeTest() {
			assertThat(numbers.size()).isEqualTo(3);
		}
	}

	@Nested
	@DisplayName("요구사항 2")
	class Requirement2Test {
		@Test
		@Order(1)
		@DisplayName("Set 의 contains() 메소드를 활용해 1,2,3 값이 존재하는지 확인")
		void containsTest() {
			assertThat(numbers.contains(1)).isTrue();
			assertThat(numbers.contains(2)).isTrue();
			assertThat(numbers.contains(3)).isTrue();
		}

		@ParameterizedTest
		@ValueSource(ints = {1, 2, 3})
		@Order(2)
		@DisplayName("Set 의 contains() 메소드를 활용해 1,2,3 값이 존재하는지 Parameterized 로 확인")
		void containsParameterizedTest(int input) {
			assertThat(numbers.contains(input)).isTrue();
		}
	}

	@Nested
	@DisplayName("요구사항 3")
	class Requirement3Test {
		@ParameterizedTest
		@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
		@DisplayName("Set 의 contains() 메소드를 활용해 1,2,3 값이 존재하고 4,5는 존재하지 않는지 Parameterized 로 확인")
		void containsTrueFalseParameterizedTest(int input, boolean result) {
			assertThat(numbers.contains(input)).isEqualTo(result);
		}
	}
}
