package racingcar;

import java.util.Objects;

public class CarMileage {
	private int mileage;

	public CarMileage(int mileage) {
		this.mileage = mileage;
	}

	public void increase() {
		this.mileage += 1;
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
}
