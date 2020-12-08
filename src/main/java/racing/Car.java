package racing;

import java.util.function.IntPredicate;

class Car {

	// TODO : refactor : moveCondition 과 moveChanceGenerator 합치기 ?
	private final IntPredicate moveCondition;
	private final MoveChanceGenerator moveChanceGenerator;
	private int position;

	Car(IntPredicate moveCondition, MoveChanceGenerator moveChanceGenerator) {
		this.moveCondition = moveCondition;
		this.moveChanceGenerator = moveChanceGenerator;
		this.position = 0;
	}

	public void getMoveForwardChance() {
		final int chance = getMoveChanceGenerator().generateChance();
		if (getMoveCondition().test(chance)) {
			moveForward();
		}
	}

	private MoveChanceGenerator getMoveChanceGenerator() {
		return this.moveChanceGenerator;
	}

	private IntPredicate getMoveCondition() {
		return this.moveCondition;
	}

	void moveForward() {
		this.position++;
	}

	int getPosition() {
		return this.position;
	}
}
