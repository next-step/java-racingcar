package study;

/*
 * 클래스 이름 : AutomobileRace
 * 버전 정보 : 0.0.1
 * 날짜 : 2021-07-31
 * 저작권 주의 : by minyul
 */

import java.util.Map;

public class AutomobileRace {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		inputView.setValues();

		int carCount = inputView.getCarCount();
		int executionCount = inputView.getExecutionCount();

		AutomobileRaceService automobileRaceService = new AutomobileRaceService(carCount);
		ResultView resultView = new ResultView();

		resultView.getResultComment();

		for(int i = 0 ; i < executionCount ; ++i) {
			automobileRaceService.startRace();
			Map<Integer, String> carContainer = automobileRaceService.getCarContainer();
			resultView.startResultView(carContainer);
		}
	}
}
