package racing.model;

public class MoveStrategy {

	private static final RandomNumber randomNumber = new RandomNumber();
	private static final int MOVABLE_NUMBER = 4;

	public boolean isMovable() {
		return randomNumber.getRandomNumber() >= MOVABLE_NUMBER;
	}
}
