package com.woowahan.racing.model;

import java.util.List;

import com.woowahan.racing.constant.Message;

public class InputResult {

	private final int tryCount;
	private final List<String> carNames;

	private InputResult(List<String> carNames, int tryCount) {
		if (carNames == null || carNames.isEmpty()) {
			throw new IllegalArgumentException(Message.MSG_NULL_OR_EMPTY_CAR_NAMES);
		}
		if (tryCount <= 0) {
			throw new IllegalArgumentException(Message.MSG_POSITIVE_NUMBER);
		}
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

	public static InputResult of(List<String> carNames, int tryCount) {
		return new InputResult(carNames, tryCount);
	}

	public int getCarCount() {
		return carNames.size();
	}

	public int getTryCount() {
		return tryCount;
	}

	public List<String> getCarNames() {
		return carNames;
	}

}
