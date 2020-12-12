package edu.nextstep.racing.domain;

import java.util.function.Supplier;

import edu.nextstep.racing.util.NumberUtil;

public class Car implements Comparable {
	public static final Supplier<Boolean> ALWAYS_MOVE_STRATEGY = () -> true;
	public static final Supplier<Boolean> NEVER_MOVE_STRATEGY = () -> false;
	private static final int STOP_LIMIT_NUMBER = 4;
	public static final Supplier<Boolean> RANDOM_MOVE_STRATEGY = () ->
		NumberUtil.generateRandomDigit() >= STOP_LIMIT_NUMBER;
	private final Supplier<Boolean> moveStrategy;
	private final Name name;
	private Location location;

	public Car(String name) {
		this(name, RANDOM_MOVE_STRATEGY);
	}

	public Car(String name, int location) {
		this(name, location, RANDOM_MOVE_STRATEGY);
	}

	public Car(String name, Supplier<Boolean> movestrategy) {
		this(name, 0, movestrategy);
	}

	public Car(String name, int location, Supplier<Boolean> moveStrategy) {
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

	public Name getName() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		return location.compareTo(((Car)o).getLocation());
	}
}