package carRacing.level3.model.strategy;

public class RandomMovingStrategy implements MovingStrategy {

	private final int PIVOT = 4;
	private final int BOUNDARY = 10;
	RandomNum randomNum = new RandomNum();

	@Override
	public Boolean isMovable() {

		int num = randomNum.randomNum();

		if (num >= PIVOT && num < BOUNDARY) {
			return true;
		}
		return false;
	}

}
