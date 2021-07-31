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

		// 필요한 것 : 입력 역할의 InputView, 출력 역할의 ResultView
		//            차 역할의 Car, 랜덤 숫자를 주는 역할의 NumberContainer

		// 입력 역할
		InputView inputView = new InputView();
		inputView.setValues();

		// 차 생성
		List<Car> carList = new ArrayList<>();
		for(int index = 1 ; index <= inputView.getCarCount() ; ++index) {
			carList.add(new Car(index, ""));
		}



	}
}
