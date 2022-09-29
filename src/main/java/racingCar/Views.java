package racingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

	// public static void findWinner(Cars cars) {
	// 	List<Integer> forwardCount = new ArrayList<>();
	//
	// 	for (int i = 0; i < cars.getCars().size(); i++) {
	// 		List<Integer> overFour = cars.getCars().get(i).getStatus()
	// 			.stream()
	// 			.filter(status -> status > 4)
	// 			.collect(Collectors.toList());
	//
	// 		System.out.println("overFour : "+overFour);
	//
	// 		forwardCount.add(overFour.size());
	// 	}
	//
	// 	Print.winner(cars, winners(forwardCount));
	// }
	//
	// private static List<Integer> winners(List<Integer> forwardCount) {
	// 	Collections.sort(forwardCount);
	// 	int max = forwardCount.get(forwardCount.size() - 1);
	//
	// 	List<Integer> peopleIndex = new ArrayList<>();
	//
	// 	for (Integer index : forwardCount) {
	// 		winnerList(max, peopleIndex, index);
	// 	}
	//
	// 	return peopleIndex;
	// }
	//
	// private static void winnerList(int max, List<Integer> peopleIndex, Integer index) {
	// 	if (max == index) {
	// 		peopleIndex.add(index);
	// 	}
	// }
}
