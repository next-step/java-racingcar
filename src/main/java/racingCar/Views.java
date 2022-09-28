package racingCar;

import java.util.List;

public class Views {
	private static final int MOVECONDITION = 4;

	public static void results(Cars cars, int index) {
		for (int i = 0; i < cars.getCars().size(); i++) {
			Print.printResult(cars.getCars().get(i).getName(), move(cars.getCars().get(i).getStatus(), index));
		}
		Print.newLine();
	}

	public static String move(List<Integer> input, int index) {
		String temp = "";
		for (int i = 0; i < index; i++) {
			temp = validateOverFour(input, temp, i);
		}
		return temp;
	}

	private static String validateOverFour(List<Integer> input, String temp, int i) {
		if (4 <= input.get(i)) {
			temp += "-";
		}
		return temp;
	}
}
