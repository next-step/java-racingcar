package racingWinner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RacingGame {
	
	private List<CarFactory> cars;
	
	public RacingGame(String[] carNamesArray) {
		cars = new ArrayList<>();
		for(int i = 0; i < carNamesArray.length; i++) {
			CarFactory car = new CarFactory(carNamesArray[i]);
			cars.add(car);
		}
	}
	
	public RacingGame(List<CarFactory> carList) {
		this.cars = carList;
	}
	
	public void makeCar(String[] carNamesArray) {
		cars = new ArrayList<>();
		for(int i = 0; i < carNamesArray.length; i++) {
			CarFactory car = new CarFactory(carNamesArray[i]);
			cars.add(car);
		}
	}
	
	
	public void racing(int reps, Random random) {
		for(int i = 1; i <= reps; i++) {
			cars =  runOrStopWithRandom(random);
			System.out.println(i + "번째");
			PrintGame.printCars(cars);
			System.out.println();
			System.out.println();
		} 
	}
	
	public List<CarFactory> runOrStopWithRandom(Random random) {
		for(int i = 0; i < cars.size(); i++) {
			CarFactory car = cars.get(i);
			car.go(random.nextInt(10));
		}
		return cars;
	}
	
	public int getMaxLocationWithList() {
		return cars.stream()
	            .max(Comparator.comparing(CarFactory::getLocation))
	            .map(CarFactory::getLocation)
	            .get();
	}
	
	public void getWinner() {
		int max = getMaxLocationWithList();
		Stream<String> winner = cars.stream()
				.filter(car -> car.getLocation() == max)
				.map(car -> car.getName());
		PrintGame.printWinner(winner);
	}
	
}
