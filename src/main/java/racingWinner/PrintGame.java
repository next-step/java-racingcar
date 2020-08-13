package racingWinner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintGame {
	
	public static void printCars(List<CarFactory> cars) {
		for(int i = 0; i < cars.size(); i++) {
			System.out.println(printCar(cars.get(i)));
			System.out.println();
		}
	}
	
	public static void printWinner(Stream<String> winners) {
		String winner = winners.collect(Collectors.joining(", "));
		System.out.println(winner + "가 최종 우승했습니다.");
	}
	
	public static String printCar(CarFactory car) {
		String value = car.getName() + " : ";
		for(int i = 0; i < car.getLocation(); i++) {
			value = value + "-";
		}
		return value;
	}
}
