package racing.view;

import racing.utils.StringUtils;
import racing.vo.Cars;

public class ResultView {

	public void printTitle() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public void printProgress(Cars carList) {
		System.out.println(carList.serialize());
	}
	
	public void printWinner(Cars cars) {
		String winners = cars.serializeName();
		if ( StringUtils.isBlank(winners) ) {
			System.out.println("최종 우승자가 없습니다.");
			return;
		}
		System.out.println(winners + " 이(가) 최종 우승했습니다.");
	}
}
