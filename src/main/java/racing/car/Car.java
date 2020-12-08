package racing.car;

import java.util.function.IntPredicate;

public class Car {

	// TODO : refactor : moveCondition 과 moveChanceGenerator 합치기 ?
	private final IntPredicate moveCondition;
	private final MoveChanceGenerator moveChanceGenerator;
	private int position;

	public Car(IntPredicate moveCondition, MoveChanceGenerator moveChanceGenerator) {
		this.moveCondition = moveCondition;
		this.moveChanceGenerator = moveChanceGenerator;
		this.position = 0;
	}

	public void getMoveForwardChance() {
		final int chance = this.moveChanceGenerator.generateChance();
		if (this.moveCondition.test(chance)) {
			moveForward();
		}
	}

	public int getPosition() {
		return this.position;
	}

	void moveForward() {
		this.position++;
	}
}
