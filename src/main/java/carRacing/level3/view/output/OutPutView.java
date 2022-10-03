package carRacing.level3.view.output;

import carRacing.level3.model.Cars;

public class OutPutView {

	public void showRace(Cars cars,int totalCarNum){

		for(int i = 0 ; i < totalCarNum; i++){
			printLocation(cars.carLocation(i));
		}

	}

	public void printLocation(int location) {
		System.out.println("-".repeat(location));
	}

	public void printSpace() {
		System.out.println("\n");
	}
}