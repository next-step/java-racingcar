package racingGame.domain;

import java.util.Random;

public class RandomMovable implements Movable {
	
	private int MOVABLENUMBER = 4;
	
	@Override
	public boolean checkMovable() {
		Random random = new Random();
		return random.nextInt(10) >= MOVABLENUMBER;
	}
}
