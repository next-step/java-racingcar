package racingcar.util;

import racingcar.domain.Cars;

public class Views {

	public static void results(Cars cars) {
		for (int i = 0; i < cars.getCars().size(); i++) {
			Print.printResult(cars.getCars().get(i).getName().getName(), move(cars.getCars().get(i).getStatus().getPosition()));
		}
		Print.newLine();
	}

	public static void winOfRacing(Cars cars) {
		Print.printWinner(cars.findWinner());
	}

	public static String move(int input) {
		String temp = "";
		for (int i = 0; i < input; i++) {
			temp += "-";
		}
		return temp;
	}
}
