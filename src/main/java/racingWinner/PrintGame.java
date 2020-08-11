package racingWinner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintGame {
	
	public static void printCars(List<Car> cars) {
		for(int i = 0; i < cars.size(); i++) {
			System.out.println(printCar(cars.get(i)));
			System.out.println();
		}
	}
	
	//Stream<Car> 
	public static void printWinner(Stream<Car> winner) {
//		for(int i = 0; i < winner.size(); i++) {
//		System.out.print(winner.get(i).getName() + seperator(winner.size(), i + 1));
//		}
		winner.forEach(car -> System.out.print(car.getName()));
		System.out.print("get winner.");
	}
	
	//Stream<String>
	public static void printWinner2(Stream<String> winners) {
		String winner = winners.collect(Collectors.joining(", "));
		System.out.println(winner + "get winner.");
	}
	
	
	public static String seperator(int size, int compare) {
		if(size > compare) {
			return ", ";
		}
		return "";
	}
	
	public static String printCar(Car car) {
		String value = car.getName() + " : ";
		for(int i = 0; i < car.getLocation(); i++) {
			value = value + "-";
		}
		return value;
	}
}
