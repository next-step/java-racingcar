package racingcar.domain;

import java.util.Random;

public class MoveStrategy {
	static Random random = new Random();
	public static int random(){
		return random.nextInt(10);
	}
}
