package carRacing.level3.model.strategy;

public class RandomMovingStrategy implements MovingStrategy {

	private static final Integer PIVOT = 4;
	private static final Integer BOUNDARY = 10;
	RandomNum randomNum= new RandomNum();

	@Override
	public Boolean getMovement(){
		return isMovable(randomNum.randomNum());
	}

	@Override
	public Boolean isMovable(int num) {

		if (num >= PIVOT && num < BOUNDARY) {
			return true;
		}
		return false;
	}
}
