package step3.domain;

public class RacingCarGame {
	private final Cars cars;
	private final TryNumber tryNumber;

	public RacingCarGame(CarNumber carNumber, TryNumber tryNumber) {
		this.cars = new Cars(carNumber.createCars());
		this.tryNumber = tryNumber;
	}

	public void play() {
		tryNumber.play();
		cars.goOrStop();
	}

	public Cars getCars() {
		return this.cars;
	}

	public boolean playing() {
		return tryNumber.playing();
	}
}
