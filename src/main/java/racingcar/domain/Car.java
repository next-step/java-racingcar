package racingcar.domain;

import java.util.Scanner;

public class Car {
	private int move = 0;

	public void moveForward(int randomNum) {
		if (randomNum >= 4) {
			move++;
		}
	}

	public int getMoveInfo() {
		return move;
	}

}
