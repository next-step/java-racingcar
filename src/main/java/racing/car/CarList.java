package racing.car;

public class CarList {

	private final Car[] cars;
	private final int numberOfCars;

	public CarList(int numberOfCars) {
		this.numberOfCars = numberOfCars;
		cars = new Car[numberOfCars];
		for (int i = 0; i < this.numberOfCars; i++) {
			cars[i] = new Car(4, 1, 1);
		}
	}

	public void moveAll(int[] bounds) {
		for (int i = 0; i < this.numberOfCars; i++) {
			cars[i].move(bounds[i]);
		}
	}

	public int getNumberOfCars() {
		return numberOfCars;
	}

	public Car get(int index) {
		return cars[index];
	}

	public Car[] getAll() {
		return cars;
	}
}
