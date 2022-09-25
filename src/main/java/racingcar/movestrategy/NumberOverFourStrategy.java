package racingcar.movestrategy;

import racingcar.numberstrategy.NumberStrategy;

public class NumberOverFourStrategy implements MoveStrategy {

	private final NumberStrategy numberStrategy;

	public NumberOverFourStrategy(NumberStrategy numberStrategy) {
		this.numberStrategy = numberStrategy;
	}

	@Override
	public boolean isMovable() {
		return numberStrategy.generate() >= 4;
	}
}
