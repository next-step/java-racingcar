package racingcar.movestrategy;

import racingcar.numberstrategy.NumberStrategy;

public class NumberOverFourStrategy implements MoveStrategy {

	public static final int MOVE_BOUNDARY_INCLUSIVE = 4;

	private final NumberStrategy numberStrategy;

	public NumberOverFourStrategy(NumberStrategy numberStrategy) {
		this.numberStrategy = numberStrategy;
	}

	@Override
	public boolean isMovable() {
		return numberStrategy.generate() >= MOVE_BOUNDARY_INCLUSIVE;
	}
}
