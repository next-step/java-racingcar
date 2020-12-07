package com.woowahan.racing.model;

import java.util.Random;

public class CarGameRandom implements GameRandom {

	private static final int MAX_NUMBER_FOR_MOVE = 9;
	private static final int MIN_NUMBER_FOR_MOVE = 4;

	@Override
	public boolean isWin() {
		int randomBound = MAX_NUMBER_FOR_MOVE + 1;
		return new Random().nextInt(randomBound) >= MIN_NUMBER_FOR_MOVE;
	}
}
