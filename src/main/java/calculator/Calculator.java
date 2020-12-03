package calculator;

/**
 * @author : byungkyu
 * @date : 2020/12/02
 * @description : 계산
 **/
public class Calculator {
	private int result;

	public Calculator() {
		result = 0;
	}

	public void calculate(String arg) {
		checkUserInput(arg);
	}

	private void checkUserInput(String arg) {
		checkUserInputEmpty(arg);
	}

	private void checkUserInputEmpty(String arg) {
		if (arg.trim().isEmpty())
			throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
	}
}
