package simpleracing.execute;

public class Car {
	private String name;
	private String location;

	public Car(String name) {
		this.name = name;
		this.location = Direction.STOP.getSign();
	}

	public String getLocation() {
		return this.location;
	}

	public String getName() {
		return this.name;
	}

	public void play(Movable moving) {
		if (moving.possible()) {
			advance();
		}
	}

	private void advance() {
		location += Direction.ADVANCE.getSign();
	}

	public void move(Direction direction) {
		location += direction.getSign();
	}
}
