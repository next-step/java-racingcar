package racingcar;

import java.util.Objects;

public class CarMileage implements Comparable<CarMileage> {
	public static final String MILEAGE_MINIMUM_CONDITION_MESSAGE = "0보다 작을 수 없습니다.";
	public static final int MILEAGE_MINIMUM_CONDITION = 0;
	private int mileage;

	public CarMileage(int mileage) {
		if(mileage < MILEAGE_MINIMUM_CONDITION) {
			throw new IllegalStateException(MILEAGE_MINIMUM_CONDITION_MESSAGE);
		}
		this.mileage = mileage;
	}

	public void increase() {
		this.mileage += 1;
	}

	public int toInteger() {
		return this.mileage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarMileage that = (CarMileage)o;
		return mileage == that.mileage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mileage);
	}

	@Override
	public int compareTo(CarMileage other) {
		return Integer.compare(this.mileage, other.mileage);
	}
}
