package racing;

import racing.object.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class RacingGame {
	
	private List<Car> carList = new ArrayList<>();
	private int time;
	
	public RacingGame(String[] cars, int times) {
		makeCarList(cars);
		this.time = times;
	}
	
	public List<Car> getCarList() {
		return carList;
	}
	
	private void makeCarList(String[] cars) {
		for (String name : cars) {
			carList.add(new Car(name));
		}
	}
	
	public boolean isInTime(int i) {
		return i < time;
	}
	
	public List<Car> move() {
		for (Car car : carList) {
			car.move();
		}
		return carList;
	}
	
	public List<Car> getWinner() {
		return carList.stream().filter(car -> car.getPosition() >= getWinnerPos())
				.collect(Collectors.toList());
	}
	
	private int getWinnerPos() {
		return carList.stream().max(comparing(Car::getPosition)).get().getPosition();
	}
}
