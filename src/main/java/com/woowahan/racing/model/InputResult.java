package com.woowahan.racing.model;

public class InputResult {

	private final int carCount;
	private final int tryCount;

	private InputResult(int carCount, int tryCount) {
		this.carCount = carCount;
		this.tryCount = tryCount;
	}

	public static InputResult of(int carCount, int tryCount) {
		return new InputResult(carCount, tryCount);
	}

	public int getCarCount() {
		return carCount;
	}

	public int getTryCount() {
		return tryCount;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("InputResult{");
		sb.append("carCount=").append(carCount);
		sb.append(", tryCount=").append(tryCount);
		sb.append('}');
		return sb.toString();
	}
}
