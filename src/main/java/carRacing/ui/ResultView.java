package carRacing.ui;

import java.util.List;

import carRacing.domain.Car;

public class ResultView {

	private static final char LOCATION_REPRESENTATION_SYMBOL = '-';
	private static final String NAME_LOCATION_DELIMITER = " : ";

	public void printStatus(List<Car> cars) {
		for (Car car : cars) {
			this.printName(car);
			this.printLocation(car);
			this.printLineSpace();
		}
		this.printLineSpace();
	}

	private void printName(Car car) {
		System.out.print(car.getName().getName() + NAME_LOCATION_DELIMITER);
	}

	private void printLocation(Car car) {
		for (int i = 0; i < car.getLocation().getLocation(); i++) {
			System.out.print(LOCATION_REPRESENTATION_SYMBOL);
		}
	}

	private void printLineSpace() {
		System.out.println();
	}
}
