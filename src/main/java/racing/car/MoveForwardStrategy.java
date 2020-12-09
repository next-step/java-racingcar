package racing.car;

public interface MoveForwardStrategy {
	int createMoveForwardChance();
	boolean isSatisfiedToMoveForward(int chance);

	default boolean isMovableChance() {
		int moveForwardChance = createMoveForwardChance();
		return isSatisfiedToMoveForward(moveForwardChance);
	}
}
