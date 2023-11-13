package racingcar.domain;

import java.util.Random;

public class RandomStrategy implements MoveStrategy{
	@Override
	public int move() {
		return new Random().nextInt(10);
	}
}
