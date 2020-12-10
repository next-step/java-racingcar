package step3;

public class RacingCarGame {
	private final Cars cars;
	private final int tryNumber;

	public RacingCarGame(int carNumber, int tryNumber) {
		this.cars = new Cars(carNumber, RandomNumberGenerator.getInstance());
		this.tryNumber = tryNumber;
	}

	public Records play() {
		Records records = new Records();

		for (int i = 0; i < tryNumber; i++) {
			cars.goOrStop();
			records.add(new Record(cars.cloneList()));
		}

		return records;
	}
}
