package edu.nextstep.racing.domain;

import java.util.function.Supplier;

import edu.nextstep.racing.util.NumberUtil;

public class Car {
	public static final int STOP_LIMIT_NUMBER = 4;
	private Supplier<Integer> numberGenerator;
	private int location;
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}