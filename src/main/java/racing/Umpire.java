package racing;

import java.util.Random;

public class Umpire {

	private Random random = new Random();
	private int advanceCondition;

	public void resetAdvanceCondition() {
		this.advanceCondition = random.nextInt(10);
	}

	public boolean isGoStraight() {
		return this.advanceCondition >= 4;
	}

}
