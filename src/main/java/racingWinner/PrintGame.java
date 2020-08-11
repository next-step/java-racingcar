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
		System.out.print("가 최종 우승했습니다.");
	}
	
	//Stream<String>
	public static void printWinner2(Stream<String> winners) {
		String winner = winners.collect(Collectors.joining(", "));
		System.out.println(winner + "가 최종 우승했습니다.");
	}
	
	
	public static String seperator(int size, int compare) {
		if(size > compare) {
			return ", ";
		}
		return "";
	}
	
	//출력은 출력 객체에 책임지게 변경
	public static String printCar(Car car) {
		String value = car.getName() + " : ";
		for(int i = 0; i < car.getLocation(); i++) {
			value = value + "-";
		}
		return value;
	}
}
