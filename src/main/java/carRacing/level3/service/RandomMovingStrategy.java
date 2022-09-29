package carRacing.level3.service;

public class RandomMovingStrategy {

	private static final Integer PIVOT = 4;
	private static final Integer BOUNDARY = 10;

	RandomNum randomNum= new RandomNum();

	public Boolean getRandomMovement(){
		return isMovable(randomNum.randomNum());
	}

	public Boolean isMovable(int num) {

		if (num >= PIVOT && num < BOUNDARY) {
			return true;
		}
		return false;
	}
}
