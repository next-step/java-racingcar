package racinggame.car;

import org.apache.commons.lang3.StringUtils;
import racinggame.rule.RacingGameRule;

/**
 * Created by hspark on 03/11/2018.
 */
public class Car {

	private String name;
	private int position;

	public Car() {
		name = StringUtils.EMPTY;
	}

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveForward(RacingGameRule gameRule) {
		if (gameRule.isAvailableMoving(this)) {
			position++;
		}
	}

}
