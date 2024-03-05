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

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetCollectionTest {
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
	@DisplayName("Set의 size() 메서드는 Set의 크기를 반환한다.")
	void 요구사항1() {
		//when & then
		assertThat(numbers.size()).isEqualTo(3);

	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("ParameterizedTest의 ValueSource를 활용하여 중복 코드 제거한다.")
	void 요구사항2(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("ParameterizedTest의 CsvSource를 활용하여 입력 값에 따라 결과 값이 다른 테스트를 진행한다.")
	void 요구사항3(int number, boolean expected) {
		//when & then
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}


}
