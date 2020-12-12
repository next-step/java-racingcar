package racing.car;

import java.util.Objects;
import java.util.function.Function;

public class RacingCar {

	private final CarName carName;
	private final MoveChanceGenerator moveChanceGenerator;
	private int position;

	RacingCar(CarName carName, MoveChanceGenerator moveChanceGenerator) {
		this(carName, moveChanceGenerator, 0);
	}

	RacingCar(CarName carName, MoveChanceGenerator moveChanceGenerator, int position) {
		this.carName = carName;
		this.moveChanceGenerator = moveChanceGenerator;
		this.position = position;
	}

	void getMoveForwardChance() {
		if (this.moveChanceGenerator.getMoveChance()) {
			this.moveForward();
		}
	}

	public CarName getCarName() {
		return this.carName;
	}

	public int getPosition() {
		return this.position;
	}

	boolean isEqualPosition(int position) {
		return Objects.equals(this.position, position);
	}

	void moveForward() {
		this.position++;
	}

	String toString(Function<RacingCar, String> stringFunction) {
		return stringFunction.apply(this);
	}
}
