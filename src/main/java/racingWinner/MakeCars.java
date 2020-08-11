package racingWinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeCars {

	public static List<Car> makeCars(String[] carNamesArray) {
		List<Car> cars = new ArrayList<Car>();
		for(int i = 0; i < carNamesArray.length; i++) {
			Car car = new Car(carNamesArray[i]);
			cars.add(car);
		}
		return cars;
	}
	
	public static List<Car> runOrStopWithRandom(List<Car> cars, Random random) {
		for(int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			car.go(random.nextInt(10));
		}
		return cars;
	}
	
	
	
	
}
