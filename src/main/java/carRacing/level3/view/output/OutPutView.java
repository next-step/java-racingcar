package carRacing.level3.view.output;

import carRacing.level3.model.Cars;
import java.util.List;

public class OutPutView {

	private final String DELIMITER = ",";

	public void showRace(Cars cars) {
		for (int i = 0; i < cars.totalNum(); i++) {
			System.out.printf("%s : %s\n", cars.carName(i), "-".repeat(cars.carLocation(i)));
		}
		System.out.println("\n");
	}

	public void showWinner(List<String> winnerList) {
		String winner = String.join(DELIMITER, winnerList);
		System.out.printf(winner + "가 최종 우승을 하였습니다");
	}
}