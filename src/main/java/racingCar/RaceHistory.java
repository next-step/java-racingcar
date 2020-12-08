package racingCar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/08
 * @description :
 **/
public class RaceHistory {
	private List<List<Car>> history;

	public RaceHistory() {
		this.history = new ArrayList<>();
	}

	public int getCount() {
		return history.size();
	}

	public List<List<Car>> get() {
		return history;
	}

	public void add(List<Car> lapHistory) {
		history.add(lapHistory);
	}
}
