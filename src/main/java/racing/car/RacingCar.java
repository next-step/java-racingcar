package racing.car;

public class RacingCar {

	private final String carName;
	private final MoveChanceGenerator moveChanceGenerator;
	private int position;

	RacingCar(String carName, MoveChanceGenerator moveChanceGenerator) {
		this.carName = carName;
		this.moveChanceGenerator = moveChanceGenerator;
	}

	void getMoveForwardChance() {
		if (this.moveChanceGenerator.getMoveChance()) {
			this.moveForward();
		}
	}

	public String getCarName() {
		return this.carName;
	}

	public int getPosition() {
		return this.position;
	}

	void moveForward() {
		this.position++;
	}
}
