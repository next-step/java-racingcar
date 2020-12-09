package edu.nextstep.racing;

import java.util.function.Supplier;

public class Car {
	public static final int STOP_LIMIT_NUMBER = 4;
	private Supplier<Integer> numberGenerator;
	private int location;

	public Car() {
		this(NumberUtil::generateRandomDigit);
	}

	public Car(Supplier<Integer> numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void tryToMove() {
		if (checkIfMove()) {
			location++;
		}
	}

	public boolean checkIfMove() {
		return numberGenerator.get() >= STOP_LIMIT_NUMBER;
	}

	public int getLocation() {
		return location;
	}
}