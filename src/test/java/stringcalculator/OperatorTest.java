package stringcalculator;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

	@ParameterizedTest(name = "사칙연산 테스트 {index} [{arguments}]")
	@CsvSource(value = {
			"1,+,1,2",
			"10,-,10,0",
			"-1,*,1,-1",
			"24,/,7,3"
	})
	@DisplayName("사칙연산 테스트")
	void calculate(int leftOperand, String sign, int rightOperand, int sum) throws Exception {
		//given
		Operator operator = Operator.from(sign);

		//when
		int solution = operator.calculate(leftOperand, rightOperand);

		//then
		assertThat(solution).isEqualTo(sum);
	}

	@Test
	@DisplayName("잘못된 연산자를 입력한 경우 테스트")
	void wrong_sign() throws Exception {
		//given
		String sign = "sign";
		String exceptionMessage = "잘못된 연산자입니다.";

		//when
		ThrowingCallable throwingCallable = () -> Operator.from(sign);

		//then
		assertException(exceptionMessage, throwingCallable);

	}

	@Test
	@DisplayName("나누기 분모가 0인 경우")
	void divided_by_zero() throws Exception {
		//given
		Operator operator = Operator.from("/");
		String exceptionMessage = "0 으로 나눌 수 없습니다.";

		//when
		ThrowingCallable throwingCallable = () -> operator.calculate(100, 0);

		//then
		assertException(exceptionMessage, throwingCallable);

	}

	private void assertException(String exceptionMessage, ThrowingCallable throwingCallable) {
		assertThatIllegalArgumentException()
				.isThrownBy(throwingCallable)
				.withMessage(exceptionMessage);
	}


}
