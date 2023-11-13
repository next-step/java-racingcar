package racing.model;

public class CarName {

	private final String name;

	public CarName(String name) throws IllegalArgumentException {
		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
		this.name = name;
	}

	public String name() {
		return name;
	}

	public CarName deepCopy() {
		return new CarName(name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CarName carName = (CarName) o;

		return name() != null ? name().equals(carName.name()) : carName.name() == null;
	}

	@Override
	public int hashCode() {
		return name() != null ? name().hashCode() : 0;
	}
}
