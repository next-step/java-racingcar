package study;

/*
 * 클래스 이름 : AutomobileRace
 * 버전 정보 : 0.0.2
 * 날짜 : 2021-07-31
 * 저작권 주의 : by minyul
 */

import java.util.ArrayList;
import java.util.List;

public class AutomobileRace {

	public static void main(String[] args) {

		// 입력 역할 & 출력 역할
		InputView inputView = new InputView();
		inputView.setValues();
		ResultView resultView = new ResultView();

		// 랜덤 숫자 제조기
		NumberContainer numberContainer = new NumberContainer();

		// 차 생성
		List<Car> carList = new ArrayList<>();
		for(int carId = 1 ; carId <= inputView.getCarCount() ; carId++) {
			carList.add(new Car( 0));
		}

		// 경기 시작 & 결과
		resultView.getResultComment();
		Stadium stadium = new Stadium(numberContainer);
		for(int raceIndex = 1; raceIndex <= inputView.getExecutionCount() ; raceIndex++) {
			stadium.startRace(carList);
			resultView.viewResult(carList);
		}
	}
}
