package carRacing.level3.view.output;


import carRacing.level3.model.Cars;

public class OutPutView {

	public void showRace(Cars cars, int totalCarNum) {
		for (int i = 0; i < totalCarNum; i++) {
			System.out.printf("%s : %s\n", cars.carName(i), "-".repeat(cars.carLocation(i)));
		}
		System.out.println("\n");
	}
}