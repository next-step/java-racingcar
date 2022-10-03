package carRacing.level3.view.output;

import carRacing.level3.model.Cars;

public class OutPutView {

	//cars리스트가 들어오면 안에 다 빼서 /n도 함께 출력해주기

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