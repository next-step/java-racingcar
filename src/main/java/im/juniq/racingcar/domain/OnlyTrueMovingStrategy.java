package im.juniq.racingcar.domain;

public class OnlyTrueMovingStrategy implements MovingStrategy {
	@Override
	public boolean isMoving() {
		return true;
	}
}
