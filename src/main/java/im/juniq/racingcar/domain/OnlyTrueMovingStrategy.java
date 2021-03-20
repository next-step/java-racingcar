package im.juniq.racingcar.domain;

public class OnlyTrueMovingStrategy implements MovingStrategy {
	@Override
	public boolean movable() {
		return true;
	}
}
