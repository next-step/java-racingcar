package racing.model;

public class MoveStrategy {

	private final NumberGenerator numberGenerator;
	private static final int MOVABLE_NUMBER = 4;

	public MoveStrategy(NumberGenerator randomNumber) {
		this.numberGenerator = randomNumber;
	}

	public boolean isMovable() {
		return numberGenerator.generate() >= MOVABLE_NUMBER;
	}
}
