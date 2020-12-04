package calculator.expression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {
	private List<String> operatorList;
	private Operators operators;

	@BeforeEach
	void setUp() {
		operatorList = Arrays.asList("+", "-", "/", "*");
		operators = new Operators(operatorList);
	}

	@DisplayName("사칙연산을 진행할 값 가져오기")
	@Test
	void getNext() {
		for (int i = 0; i < operatorList.size(); i++) {
			//when, then
			assertEquals(operatorList.get(i), operators.getNext());
		}
	}

	@DisplayName("사칙연산을 진행할 값이 남아있는지 확인")
	@Test
	void hasNext() {
		for (int i = 0; i < operatorList.size(); i++) {
			//when, then
			assertThat(operators.hasNext()).isTrue();
			operators.getNext();
		}

		//모든 값을 다 순회한 후 false 출력 확인
		assertThat(operators.hasNext()).isFalse();
	}
}