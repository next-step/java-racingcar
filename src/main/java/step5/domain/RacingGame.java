package step5.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step5.view.PrintRacingGame;

public class RacingGame {
private List<Car> cars;
	
	private static final int RANDOM_VALUE = 10;
	private static final String SEPROATOR_VALUE= ", ";

	public RacingGame(List<Car> carList) {
		this.cars = carList;
	}
	
	public void racing(int reps, Random random) {
		for(int i = 1; i <= reps; i++) {
			cars =  runOrStopWithRandom(random);
			PrintRacingGame.printReps(i);
			PrintRacingGame.printCars(cars);
			PrintRacingGame.printEnter();
		} 
	}
	
	public List<Car> runOrStopWithRandom(Random random) {
		cars.stream()
		.forEach(Car -> Car.go(random.nextInt(RANDOM_VALUE)));
		
		return cars;
	}
	
	
	public int getMaxLocationWithList() {
		return cars.stream()
	            .max(Comparator.comparing(Car::getLocation))
	            .map(Car::getLocation)
	            .get();
	}
	
	public String getWinner() {
		int max = getMaxLocationWithList();
		Stream<String> winner= cars.stream()
				.filter(car -> car.getLocation() == max)
				.map(car -> car.getName());
		return winner.collect(Collectors.joining(SEPROATOR_VALUE));
	}
}
