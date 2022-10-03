package racingcar;

import java.util.Random;

public class Car {
	private static int LIMITOFNAMELENGTH = 5;
	private static int MAXOFRANDOM = 10;
	private static final int MOVINGCONDITION = 4;
	private final String name;
	private int stauts;

	public Car(String name) {
		if (LIMITOFNAMELENGTH < name.length() || name.isBlank()) {
			throw new RuntimeException();
		}
		this.name = name;
		this.stauts = 0;
	}

	public void movingOfRound(int random) {
		if (random >= MOVINGCONDITION) {
			this.stauts++;
		}
	}

	public int makeRandom() {
		return new Random().nextInt(MAXOFRANDOM);
	}

	public int getStatus() {
		return this.stauts;
	}

	public String getName() {
		return this.name;
	}
}
