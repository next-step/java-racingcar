package racing.car;

public class CarName {

	private final String name;

	public CarName(String name) throws IllegalArgumentException {
		if (name.length() > 5) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CarName carName = (CarName) o;

		return getName() != null ? getName().equals(carName.getName()) : carName.getName() == null;
	}

	@Override
	public int hashCode() {
		return getName() != null ? getName().hashCode() : 0;
	}
}
