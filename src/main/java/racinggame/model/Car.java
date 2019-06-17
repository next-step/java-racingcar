package racinggame.model;

import racinggame.util.RandomValueUtil;

import java.util.stream.IntStream;

public class Car {

	private static final int DEFAULT_STATUS = 1;
	private static final int MOVE_VALUE = 4;

	private int status;

	public Car() {
		this.status = DEFAULT_STATUS;
	}

	public int move() {
		status++;
		return status;
	}

	public String viewStatus() {
		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(0, status)
						 .forEach(i -> stringBuilder.append("-"));
		return stringBuilder.toString();
	}

	public boolean isMove() {
			return RandomValueUtil.getRandomValue() >= MOVE_VALUE;
	}
}
