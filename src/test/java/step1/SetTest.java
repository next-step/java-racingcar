package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/01
 * @description : Set Collection에 대한 학습 테스트
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

	@Order(1)
	@DisplayName("1.1. Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
	@Test
	void checkSetSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Order(2)
	@DisplayName("2. Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void checkSetContainsValue(int arg) {
		assertThat(numbers.contains(arg)).isTrue();
	}

	@Order(3)
	@DisplayName("3. 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void checkSetContainsValue(int input, boolean isCorrect) {
		assertThat(numbers.contains(input)).isEqualTo(isCorrect);
	}
}