package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {

	private final int round;
	private final List<RacingCar> carList;

	public Record(final int round, final List<RacingCar> carList) {
		this.round = round;
		this.carList = new ArrayList<>(carList.size());
		for (RacingCar racingCar : carList) {
			this.carList.add(new RacingCar(racingCar.getId(), racingCar.getMoveDistance()));
		}
	}

	public List<RacingCar> getCarList() {
		return carList;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Record record = (Record)o;

		return round == record.round;
	}

	@Override
	public int hashCode() {
		return round;
	}
}
