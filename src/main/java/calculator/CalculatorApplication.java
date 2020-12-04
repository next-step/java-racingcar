package calculator;

/**
 * @author : byungkyu
 * @date : 2020/12/02
 * @description : 문자열 계산기 실행
 **/
public class CalculatorApplication {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int result = calculator.calculate(View.input());
		View.printResult(result);
	}
}
