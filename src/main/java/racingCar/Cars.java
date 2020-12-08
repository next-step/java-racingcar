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
	private int raceCount;
	private int lapCount;

	public Cars() {
		this.cars = new ArrayList<>();
		this.raceCount = 0;
		this.lapCount = 0;
	}

	public void add(Car car) {
		cars.add(car);
	}

	public int getCount(){
		return cars.size();
	}

	public void race(int arg) {
		for (int i = 0; i < arg; i++) {
			runLap();
			raceCount++;
		}
	}

	public int getRaceCount() {
		return raceCount;
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
}
