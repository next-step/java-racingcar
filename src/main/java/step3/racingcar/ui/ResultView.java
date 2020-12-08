package step3.racingcar.ui;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.RacingCars;
import step3.racingcar.domain.Record;
import step3.racingcar.domain.RoundRecorder;

public class ResultView {

	public void printResult(final RoundRecorder roundRecorder) {
		System.out.println();
		System.out.println("실행 결과");
		for (Record record : roundRecorder.getRecords()) {
			printEachRecord(record.getCars());
			System.out.println();
		}
	}

	private void printEachRecord(final RacingCars racingCars) {
		for (RacingCar car : racingCars.getRacingCars()) {
			printCarMoved(car.getMoveDistance());
			System.out.println();
		}
	}

	private void printCarMoved(final int count) {
		final String CAR_MOVED = "-";

		for (int i = 0; i < count; i++) {
			System.out.print(CAR_MOVED);
		}
	}

}
