package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : byungkyu
 * @date : 2020/12/03
 * @description : 연산자 테스트
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OperatorTest {

	Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@Order(1)
	@DisplayName("1. 덧셈")
	@Test
	void sum() {
		int num1 = 5;
		int num2 = 10;
		int operate = Operator.of("+").operate(num1, num2);
		assertThat(operate).isEqualTo(15);
	}

	@Order(2)
	@DisplayName("2. 뺄셈")
	@Test
	void minus() {
		int num1 = 10;
		int num2 = 3;
		int operate = Operator.of("-").operate(num1, num2);
		assertThat(operate).isEqualTo(7);
	}

	@Order(3)
	@DisplayName("3. 곱셈")
	@Test
	void multiply() {
		int num1 = 5;
		int num2 = 10;
		int operate = Operator.of("*").operate(num1, num2);
		assertThat(operate).isEqualTo(50);
	}

	@Order(4)
	@DisplayName("4. 나눗셈")
	@Test
	void divide() {
		int num1 = 10;
		int num2 = 2;
		int operate = Operator.of("/").operate(num1, num2);
		assertThat(operate).isEqualTo(5);
	}

}