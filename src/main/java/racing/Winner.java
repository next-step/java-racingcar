package racing;

public class Winner {
	private final String name;

	public Winner(Car car) {
		this.name = car.getName();
	}

	public String getName() {
		return name;
	}
}
