package study;

/*
 * 클래스 이름 : AutomobileRace
 * 버전 정보 : 0.0.1
 * 날짜 : 2021-07-31
 * 저작권 주의 : by minyul
 */

public class AutomobileRace {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		inputView.setValues();

		int carCount = inputView.getCarCount();
		int executionCount = inputView.getExecutionCount();

		resultView.getResultComment();
	}
}
