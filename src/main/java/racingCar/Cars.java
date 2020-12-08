package racingCar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Cars {
	private List<Car> cars;
	private int matchCount;
	private int lapCount;

	public Cars(int carCount, int matchCount) {
		this.cars = new ArrayList<>();
		createCars(carCount);
		this.matchCount = matchCount;
		this.lapCount = 0;
	}

	public void add(Car car) {
		cars.add(car);
	}

	public int getCount(){
		return cars.size();
	}

	public Cars race() {
		while(matchCount != lapCount){
			runLap();
		}
		return this;
	}

	public void runLap() {
		for(Car car : cars){
			car.randomMove();
		}
		lapCount++;
	}

	public int getLapCount() {
		return lapCount;
	}

	private void createCars(int arg) {
		for(int i=0; i< arg; i++){
			Car car = new Car();
			add(car);
		}
	}
}
