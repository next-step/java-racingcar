package calculator.expression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersTest {
	private List<Integer> numberList;
	private Numbers numbers;

	@BeforeEach
	void setUp() {
		numberList = Arrays.asList(1, 2);
		numbers = new Numbers(numberList);
	}

	@DisplayName("사칙연산을 진행할 값 가져오기")
	@Test
	void getNext() {
		for (int i = 0; i < numberList.size(); i++) {
			//when, then
			assertEquals(numberList.get(i), numbers.getNext());
		}
	}

	@DisplayName("사칙연산을 진행할 값이 남아있는지 확인")
	@Test
	void hasNext() {
		for (Integer number : numberList) {
			//when, then
			assertThat(numbers.hasNext()).isTrue();
			numbers.getNext();
		}

		//모든 값을 다 순회한 후 false 출력 확인
		assertThat(numbers.hasNext()).isFalse();
	}
}