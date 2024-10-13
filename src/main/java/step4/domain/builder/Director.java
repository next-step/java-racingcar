package step4.domain.builder;

import java.util.Random;

import step4.domain.car.Car;
import step4.domain.movestrategy.AlwaysMoveStrategy;
import step4.domain.movestrategy.RandomMoveStrategy;

public final class Director {
	private static final CarBuilder carBuilder = new CarBuilder();
	private static final RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(new Random());
	private static final AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
	private static final Director director = new Director();

	private Director() {
	}

	public static Director getInstance() {
		return director;
	}

	public static Car constructFastRandomMoveCar(String name) {
		return carBuilder
			.setSpeed(3)
			.setStrategy(randomMoveStrategy)
			.setName(name)
			.build();
	}

	public static Car constructDefaultRandomMoveCar(String name) {
		return carBuilder
			.setSpeed(1)
			.setStrategy(randomMoveStrategy)
			.setName(name)
			.build();
	}

	public static Car constructFastAlwaysMoveCar(String name) {
		return carBuilder
			.setSpeed(3)
			.setStrategy(alwaysMoveStrategy)
			.setName(name)
			.build();
	}

	public static Car constructDefaultAlwaysMoveCar(String name) {
		return carBuilder
			.setSpeed(1)
			.setStrategy(alwaysMoveStrategy)
			.setName(name)
			.build();
	}
}
