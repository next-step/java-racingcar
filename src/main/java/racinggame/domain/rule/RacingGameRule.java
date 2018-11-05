package racinggame.domain.rule;

import racinggame.domain.car.Car;

/**
 * Created by hspark on 03/11/2018.
 */
public interface RacingGameRule {
	boolean isAvailableMoving(Car car);
}
