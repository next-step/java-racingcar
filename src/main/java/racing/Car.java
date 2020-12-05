package racing;

import java.util.function.IntPredicate;

class Car {

	private final IntPredicate moveCondition;
	private int position;

	Car(IntPredicate moveCondition) {
		this.moveCondition = moveCondition;
		this.position = 0;
	}

	public void getMoveForwardChance(int chance) {
		if (getMoveCondition().test(chance)) {
			moveForward();
		}
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
