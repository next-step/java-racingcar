package racinggame.model;

import java.util.stream.IntStream;

public class Car {
	private int status;
	private static final int DEFAULT_STATUS = 1;

	public Car() {
		this.status = DEFAULT_STATUS;
	}

	public int move() {
		status = status + 1;
		return status;
	}

	public int getStatus() {
		return status;
	}

	public String viewStatus() {
		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(0, status)
						 .forEach(i -> stringBuilder.append("-"));
		return stringBuilder.toString();
	}
}
