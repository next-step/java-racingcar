package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
	public static int getRandomNumber() {
		return new Random().nextInt(10);
	}

	public static boolean canMove(int randomNumber) {
		return randomNumber > 3;
	}

	public static List<Car> getCarList(int carCount) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			carList.add(new Car());
		}
		return carList;
	}

	public static void move(int tryCount, List<Car> carList) {
		for (Car car : carList){
			setResult(tryCount, car);
		}
	}

	public static void setResult(int tryCount, Car car) {
		int result = 0;
		for (int i = 0; i< tryCount; i++){
			if (RacingCar.canMove(RacingCar.getRandomNumber())){
				result++;
			}
			car.resultList.add(result);
		}
	}
}
