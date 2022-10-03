package carRacing.level3.model.strategy;

public class RandomMovingStrategy implements MovingStrategy {

	private static final int PIVOT = 4;
	private static final int BOUNDARY = 10;
	RandomNum randomNum= new RandomNum();

	@Override
	public Boolean isMovable(){
		return movingStandard(randomNum.randomNum());
	}

	@Override
	public Boolean movingStandard(int num) {

		if (num >= PIVOT && num < BOUNDARY) {
			return true;
		}
		return false;
	}
}
