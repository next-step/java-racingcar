package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private static final int MOVINGCONDITION = 4;
	private int stauts;
	private final String name;

	public Car(String name) {
		if (5 < name.length()) {
			throw new RuntimeException();
		}
		this.name = name;
		this.stauts = 0;
	}

	public int getStatus() {
		return this.stauts;
	}

	public String getName() {
		return this.name;
	}

	public void movingOfRound(int random) {
		if (random >= MOVINGCONDITION) {
			this.stauts++;
		}
	}
}
