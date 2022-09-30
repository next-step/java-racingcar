package racingCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Views {

	public static void results(Cars cars, int index) {
		for (int i = 0; i < cars.getCars().size(); i++) {
			Print.printResult(cars.getCars().get(i).getName(), move(cars.getCars().get(i).getStatus()));
		}
		Print.newLine();
	}

	public static String move(int input) {
		String temp = "";
		for (int i = 0; i < input; i++) {
			temp += "-";
		}
		return temp;
	}

	public static void winOfRacing(Cars cars) {
		List<Car> winners = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < cars.getCars().size(); i++) {
			if (max <= cars.getCars().get(i).getStatus()) {
				max = cars.getCars().get(i).getStatus();
			}
		}
		for (Car car : cars.getCars()) {
			if (car.getStatus() == max) {
				winners.add(car);
			}
		}
		Print.printWinner(winners);
	}
}
