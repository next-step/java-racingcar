package com.woowahan.racing.model;

import com.woowahan.racing.constant.Message;

public class InputResult {

	private final int carCount;
	private final int tryCount;

	private InputResult(int carCount, int tryCount) {
		if (carCount <= 0 || tryCount <= 0) {
			throw new IllegalArgumentException(Message.MSG_POSITIVE_NUMBER);
		}
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


}
