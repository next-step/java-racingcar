package racingcar;

public class RacingCar {
	public static void run() {
		Car car = new Car();
		car.tryMove(RandomUtils.createRandomNumber());
		car.tryMove(RandomUtils.createRandomNumber());
		car.tryMove(RandomUtils.createRandomNumber());
		car.tryMove(RandomUtils.createRandomNumber());
	}
}
