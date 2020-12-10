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
	@DisplayName("요구사항1: Set 객체의 size() 메소드를 활용해 크기 확인 학습")
	void setSizeTest() {

		// Set 은 중복값을 허용하지 않는다.
		userInputSetSizeTest(3);

		// Set 중복값을 허용하지 않기 때문에, numbers set 의 사이즈는 3이다.
		// userInputSetSizeTest(4); // false
	}

	/*
	 * @ParameterizedTest
	 * 하나의 테스트 메소드로 여러 개의 파라미터에 대해서 테스트.
	 *
	 * * @ValueSource
	 * 단일 인수문 사용가능하며, 사용 가능 타입: short, byte, int, long, float, double, char, boolean, java.lang.String, java.lang.Class 등이다.
	 */
	@ParameterizedTest
	@ValueSource(ints = {1, 1, 2, 3})
	@DisplayName("요구사항2: Set 객체의 value 확인")
	void setContainsValueTest(int values) {

		// 중복 코드
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();

		// 위 중복 코드 대신 ParameterizedTest 로 인해 동적화
		userInputSetContainsTest(values);
	}

	/*
	 * @CsvSource
	 * 다양한 타입의 인수를 사용할 수 있다.
	 */
	@ParameterizedTest
	@CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
	@DisplayName("요구사항3: Set 객체의 value 포함 상태 체크")
	void setCheckContainsYorN(String values, boolean result) {

		userInputSetContains(values, result);
	}

	private void userInputSetContains(String values, boolean result) {

		String separator = ",";
		for (String str : values.split(separator)) {

			assertThat(numbers.contains(Integer.parseInt(str))).isEqualTo(result);
		}
	}

	private void userInputSetContainsTest(int values) {

		assertThat(numbers.contains(values)).isTrue();
	}

	private void userInputSetSizeTest(int size) {

		assertThat(numbers.size()).isEqualTo(size);
	}
}
