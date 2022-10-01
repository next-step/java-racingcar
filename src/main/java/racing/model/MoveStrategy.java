package racing.model;

public class MoveStrategy {

	private final RandomNumber randomNumber;
	private static final int MOVABLE_NUMBER = 4;

	public MoveStrategy(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}

	public boolean isMovable() {
		return randomNumber.getRandomNumber() >= MOVABLE_NUMBER;
	}
}
