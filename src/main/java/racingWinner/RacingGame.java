package racingWinner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RacingGame {
	
	public static void racing(List<Car> cars, int reps) {
		Random random = new Random();
		for(int i = 1; i <= reps; i++) {
			cars =  RacingGame.runOrStopWithRandom(cars, random);
			System.out.println(i + "번째");
			PrintGame.printCars(cars);
			System.out.println();
			System.out.println();
		} 
	}
	
	
	//make Car
	public static List<Car> makeCars(String[] carNamesArray) {
		List<Car> cars = new ArrayList<Car>();
		for(int i = 0; i < carNamesArray.length; i++) {
			Car car = new Car(carNamesArray[i]);
			cars.add(car);
		}
		return cars;
	}
	
	//게임 진행
	public static List<Car> runOrStopWithRandom(List<Car> cars, Random random) {
		for(int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			car.go(random.nextInt(10));
		}
		return cars;
	}
	
	public static int getMaxLocationWithList(List<Car> cars) {
	
		return cars.stream()
	            .max(Comparator.comparing(Car::getLocation))
	            .map(Car::getLocation)
	            .get();
	}
	
	public static List<Car> getWinnerName(int max, Car car, List<Car> winner) {
		if(car.winner(max) != null) {
			winner.add(car);
		}
		return winner;
	}
	
//	public static void getWinner(List<Car> cars) {
//		int max = getMaxLocationWithList(cars);
//		Stream<Car> winner = cars.stream()
//				  .filter(car -> car.getLocation() == max);
//		
//		PrintGame.printWinner(winner);
//	}
	
	public static void getWinner2(List<Car> cars) {
		int max = getMaxLocationWithList(cars);
		Stream<String> winner = cars.stream()
				.filter(car -> car.getLocation() == max)
				.map(car -> car.getName());
		PrintGame.printWinner2(winner);
	}
	
}
