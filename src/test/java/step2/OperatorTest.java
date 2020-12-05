package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Operator : 사칙 연산을 수행할 수 있고 및 그 결과값을 저장하고 되돌려 줄 수 있는 클래스")
class OperatorTest {

	@DisplayName("getSum : 전체 연산은 누적된 결과값을 가지며, getSum 메소드로 현재 결과값을 리턴받을 수 있음")
	@Test
	void getSum() {
		Operator operator = new Operator(123);
		assertThat(operator.getSum()).isEqualTo(123);
	}

	@DisplayName("plus : 현재의 누적값(sum)에 input된 숫자를 더함")
	@ParameterizedTest
	@CsvSource(value = {"5,2,7", "10,5,15", "3,4,7"})
	void plus(int a, int b, int result) {
		assertThat(new Operator(a).plus(b).getSum()).isEqualTo(result);
	}

	@DisplayName("minus : 현재의 누적값(sum)에 input된 숫자를 뺌")
	@ParameterizedTest
	@CsvSource(value = {"5,2,3", "10,5,5", "3,4,-1"})
	void minus(int a, int b, int result) {
		assertThat(new Operator(a).minus(b).getSum()).isEqualTo(result);
	}

	@DisplayName("multiply : 현재의 누적값(sum)에 input된 숫자를 곱함")
	@ParameterizedTest
	@CsvSource(value = {"5,2,10", "10,5,50", "3,4,12"})
	void multiply(int a, int b, int result) {
		assertThat(new Operator(a).multiply(b).getSum()).isEqualTo(result);
	}

	@DisplayName("divide : 현재의 누적값(sum)에 input된 숫자를 나눔")
	@ParameterizedTest
	@CsvSource(value = {"5,2,2", "10,5,2", "3,4,0"})
	void divide(int a, int b, int result) {
		assertThat(new Operator(a).divide(b).getSum()).isEqualTo(result);
	}

	@DisplayName("operate : 연산자도 함께 받아 현재의 누적값(sum)에 input된 숫자를 연산함")
	@ParameterizedTest
	@CsvSource(value = {"5,+,2,7", "5,-,2,3", "5,*,2,10", "5,/,2,2"})
	void operate(int a, String operator, int b, int result) {
		assertThat(new Operator(a).operate(operator, b).getSum()).isEqualTo(result);
	}

}