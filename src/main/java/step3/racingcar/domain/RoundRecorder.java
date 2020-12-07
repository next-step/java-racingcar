package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundRecorder {

	private final List<Record> records;

	public RoundRecorder(final int round) {
		this.records = new ArrayList<>(round);
	}

	public void record(final int round, final List<RacingCar> racingCars) {
		records.add(new Record(round, racingCars));
	}

	public List<Record> getRecords() {
		return records;
	}
}
