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

}
