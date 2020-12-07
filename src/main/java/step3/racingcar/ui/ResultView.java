package step3.racingcar.ui;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.Record;
import step3.racingcar.domain.RoundRecorder;

public class ResultView {

	private final String NEXT_LINE = "\n";

	public void printResult(final RoundRecorder roundRecorder) {
		System.out.println(NEXT_LINE);
		System.out.println("실행 결과");
		for (Record record : roundRecorder.getRecords()) {
			printEachRecord(record);
			System.out.println(NEXT_LINE);
		}
	}

	private void printEachRecord(final Record record) {
		for (RacingCar car : record.getCarList()) {
			printCarMoved(car.getMoveDistance());
			System.out.println(NEXT_LINE);
		}
	}

	private void printCarMoved(final int count) {
		final String CAR_MOVED = "-";

		for (int i = 0; i < count; i++) {
			System.out.print(CAR_MOVED);
		}
	}

}
