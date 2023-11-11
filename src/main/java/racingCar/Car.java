package racingCar;

public class Car {
	public int distance;
	public void move() {
		if (RacingUtil.getRandomNumber() > 3) {
			distance++;
		}
	}
}
