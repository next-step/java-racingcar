package step3.view;

import java.util.List;

import step3.domain.RacingResult;

public class OutputView {
	private static final String MOVE_OUTPUT = "-";

	public static void viewResult(List<RacingResult> result) {
		for (int i = 0; i < result.size(); i++) {
			RacingResult resultOne = result.get(i);
			viewOneTrial(resultOne.getPositionOfCars());
			System.out.println();
		}
	}

	private static void viewOneTrial(List<Integer> cars) {
		for (int i = 0; i < cars.size(); i++) {
			viewOneCar(cars.get(i));
		}
	}

	private static void viewOneCar(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print(MOVE_OUTPUT);
		}
		System.out.println();
	}
}