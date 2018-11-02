package racinggame.rule;

import java.util.Random;

/**
 * Created by hspark on 03/11/2018.
 */
public class RandomNumberRacingGameRule implements RacingGameRule {
	private static final Random random = new Random();
	private static final int STANDARD_SCORE = 5;
	private static final int MAX_SCORE = 9;

	@Override
	public boolean isAvailableMoving() {
		return random.nextInt(MAX_SCORE + 1) > STANDARD_SCORE;
	}
}
