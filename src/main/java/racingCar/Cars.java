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

	public Cars() {
		this.cars = new ArrayList<>();
		this.raceCount = 0;
	}

	public void add(Car car) {
		cars.add(car);
	}

	public int getCount(){
		return cars.size();
	}

	public void race(int arg) {
		for (int i = 0; i < arg; i++) {
			raceCount++;
		}
	}

	public int getRaceCount() {
		return raceCount;
	}
}
