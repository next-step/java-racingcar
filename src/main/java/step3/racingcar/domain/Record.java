package step3.racingcar.domain;

public class Record {

	private final int round;
	private final RacingCars cars;

	public Record(final int round, final RacingCars cars) {
		this.round = round;
		this.cars = cars.copy();
	}

	public RacingCars getCars() {
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
