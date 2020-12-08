package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {

	private final int round;
	private final List<RacingCar> cars;

	public Record(final int round, final List<RacingCar> cars) {
		this.round = round;
		this.cars = new ArrayList<>(cars.size());
		for (RacingCar racingCar : cars) {
			this.cars.add(new RacingCar(racingCar.getId(), racingCar.getMoveDistance()));
		}
	}

	public List<RacingCar> getCars() {
		return cars;
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
