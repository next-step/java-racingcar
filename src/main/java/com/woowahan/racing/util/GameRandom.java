package com.woowahan.racing.util;

import java.util.Random;

public class GameRandom {

	private static final int BOUND = 10;
	private static final int MIN_NUMBER_FOR_MOVE = 4;

	public static boolean isGameWin() {
		return new Random().nextInt(BOUND) >= MIN_NUMBER_FOR_MOVE;
	}

}
