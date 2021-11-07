package view;

import domain.CarCount;
import domain.CarRaceGroup;

public class OutputView {

	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String NEXT_LINE = "\n";
	private static final String POSITION_MARK = "-";
	private static final String EMPTY = "";

	public static void result(CarCount carCount, CarRaceGroup carRaceGroup) {
		System.out.println(RESULT_MESSAGE);

		int carRaceGroupSize = carRaceGroup.size();
		int carCountSize = carCount.count();
		for (int i = 0; i < carRaceGroupSize; i++) {
			System.out.println(changeNumberToHyphen(carRaceGroup.carPosition(i)));
			printNextLine(i + 1, carCountSize);
		}
	}

	private static String changeNumberToHyphen(int loopNumber) {
		String carLocation = EMPTY;
		for (int i = 0; i < loopNumber; i++) {
			carLocation += POSITION_MARK;
		}

		return carLocation;
	}

	private static void printNextLine(int loopCount, int carCount) {
		if (loopCount % carCount == 0) {
			System.out.print(NEXT_LINE);
		}
	}

}
