package racingcar;

import java.util.Random;

public class Car {
	private static int LIMITOFNAMELENGTH = 5;
	private static int MAXOFRANDOM = 10;
	private static final int MOVINGCONDITION = 4;
	private final String name;
	private int status;

	public Car(String name) {
		if (LIMITOFNAMELENGTH < name.length() || name.isBlank()) {
			throw new RuntimeException();
		}
		this.name = name;
		this.status = 0;
	}

	public void movingOfRound(int random) {
		if (random >= MOVINGCONDITION) {
			this.status++;
		}
	}

	public int makeRandom() {
		return new Random().nextInt(MAXOFRANDOM);
	}

	public int getStatus() {
		return this.status;
	}

	public String getName() {
		return this.name;
	}
}
