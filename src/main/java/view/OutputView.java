package view;

import domain.CarRaceGroup;

public class OutputView {

	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String NEXT_LINE = "\n";

	public static void result(CarRaceGroup carRaceGroup) {
		System.out.println(RESULT_MESSAGE);
		for (int i = 0; i < carRaceGroup.size(); i++) {
			printMovePosition(i, carRaceGroup);
		}
	}

	private static void printMovePosition(int carRaceCount, CarRaceGroup carRaceGroup) {
		int carRaceSize = carRaceGroup.carCountByMoving(carRaceCount);
		for (int i = 0; i < carRaceSize; i++) {
			System.out.println(carRaceGroup.carLocation(carRaceCount, i));
		}
		System.out.print(NEXT_LINE);
	}
}
