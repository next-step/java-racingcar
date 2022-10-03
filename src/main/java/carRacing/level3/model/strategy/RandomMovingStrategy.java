package carRacing.level3.model.strategy;

public class RandomMovingStrategy implements MovingStrategy {

	private static final Integer PIVOT = 4;
	private static final Integer BOUNDARY = 10;
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
