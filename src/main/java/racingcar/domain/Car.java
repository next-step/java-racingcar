package racingcar.domain;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Car {
	private static final int MIN_THRESHOLD = 4;
	private int move = 0;

	public void moveForward(int randomNum) {
		if (randomNum >= MIN_THRESHOLD) {
			move++;
		}
	}

	public int getMoveInfo() {
		return move;
	}

}
