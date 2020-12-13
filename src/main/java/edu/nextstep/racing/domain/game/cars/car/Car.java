package edu.nextstep.racing.domain.game.cars.car;

import java.util.function.BooleanSupplier;

import edu.nextstep.racing.util.NumberUtil;

public class Car implements Comparable<Car> {
	private static final int STOP_LIMIT_NUMBER = 4;
	public static final BooleanSupplier RANDOM_MOVE_STRATEGY = () ->
		NumberUtil.generateRandomDigit() >= STOP_LIMIT_NUMBER;
	private final BooleanSupplier moveStrategy;
	private final Name name;
	private Location location;

	public Car(String name) {
		this(name, RANDOM_MOVE_STRATEGY);
	}

	public Car(String name, int location) {
		this(name, location, RANDOM_MOVE_STRATEGY);
	}

	public Car(String name, BooleanSupplier movestrategy) {
		this(name, 0, movestrategy);
	}

	public Car(String name, int location, BooleanSupplier moveStrategy) {
		this.name = new Name(name);
		this.location = new Location(location);
		this.moveStrategy = moveStrategy;
	}

	public void move() {
		this.location = location.move(moveStrategy);
	}

	public Location getLocation() {
		return location;
	}

	public String getName() {
		return name.getValue();
	}

	@Override
	public int compareTo(Car other) {
		return location.compareTo(other.getLocation());
	}
}