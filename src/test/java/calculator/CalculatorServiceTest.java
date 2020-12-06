package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {

	private CalculatorService calculatorService;

	@Test
	@DisplayName("계산식 ENUM 계산 테스트, 나누었을때, 정수로 출력되는지 확인")
	void enumModest() {

		CalculatorType calculatorTypeTest = CalculatorType.getOperator("/");
		assertThat(calculatorTypeTest.calculate(10,4)).isEqualTo(2);
	}

	@Test
	@DisplayName("계산식 ENUM 계산 테스트")
	void enumMultiTest() {

		CalculatorType calculatorTypeTest = CalculatorType.getOperator("*");
		assertThat(calculatorTypeTest.calculate(10,4)).isEqualTo(40);
	}

	@Test
	@DisplayName("계산식 ENUM 계산 테스트")
	void enumMinusTest() {

		CalculatorType calculatorTypeTest = CalculatorType.getOperator("-");
		assertThat(calculatorTypeTest.calculate(10,4)).isEqualTo(6);
	}

	@Test
	@DisplayName("계산식 ENUM 계산 테스트")
	void enumPlusTest() {

		CalculatorType calculatorTypeTest = CalculatorType.getOperator("+");
		assertThat(calculatorTypeTest.calculate(10,4)).isEqualTo(14);
	}

	@Test
	@DisplayName("전체 계산식 테스트")
	void userInputCalculateTest() {

		String userInput = "2 + 3 * 4 / 2";
		String[] userInputArr = userInput.split(" ");

		// 첫번 째 입력 값으로 계산기 생성
		calculatorService = new CalculatorService(Integer.parseInt(userInputArr[0]));

		// 두번 째, 계산 부호와 입력 수 반복 계산
		for (int i = 1; i < userInputArr.length; i = i + 2) {
			calculatorService.calculate(userInputArr[i], Integer.parseInt(userInputArr[i+1]));
		}

		assertThat(calculatorService.getResult()).isEqualTo(10);
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2 3", "4 - 2 2", "2 * 3 6", "10 / 2 5"}, delimiter = ' ')
	@DisplayName("계산 부호 추가 테스트")
	void calculateTest(int number1, String sign, int number2, int result) {

		calculatorService = new CalculatorService(number1);
		calculatorService.calculate(sign, number2);
		assertThat(calculatorService.getResult()).isEqualTo(result);
	}

	@Test
	@DisplayName("덧셈 계산 테스트 ")
	void plusTest() {

		calculatorService = new CalculatorService(4);
		calculatorService.calculate("+", 5);
		assertThat(calculatorService.getResult()).isEqualTo(9);
	}

	@Test
	@DisplayName("뺄셈 계산 테스트")
	void minusTest() {

		calculatorService = new CalculatorService(6);
		calculatorService.calculate("-", 4);
		assertThat(calculatorService.getResult()).isEqualTo(2);
	}

	@Test
	@DisplayName("나눗셈 계산 테스트")
	void modTest() {
		calculatorService = new CalculatorService(10);
		calculatorService.calculate("/", 2);
		assertThat(calculatorService.getResult()).isEqualTo(5);
	}

	@Test
	@DisplayName("나눗셈 결과 값 정수 테스트")
	void modResultTest() {

		// 나눗셈의 경우, 결과 값을 정수로 떨어지도록 제한 테스트
		// int 자료형으로 나누기 떄문에, 정수값을로 얻을 수 있다.
		calculatorService = new CalculatorService(7);
		calculatorService.calculate("/", 2);
		assertThat(calculatorService.getResult()).isEqualTo(3);
	}

	@Test
	@DisplayName("곱셈 계산 테스트")
	void multiTest() {

		calculatorService = new CalculatorService(3);
		calculatorService.calculate("*", 6);
		assertThat(calculatorService.getResult()).isEqualTo(18);
	}
}
