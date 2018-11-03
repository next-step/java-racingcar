package racinggame;

import racinggame.rule.RacingGameRule;

/**
 * Created by hspark on 03/11/2018.
 */
public class Car {

	private int position;

	public int getPosition() {
		return position;
	}

	public void moveForward(RacingGameRule gameRule) {
		if (gameRule.isAvailableMoving()) {
			position++;
		}
	}

}
