package racingcar.domain;

import exception.OutOfRangeException;
import util.Range;

@FunctionalInterface
public interface MovingRule {
	boolean isMoveCar();
}
