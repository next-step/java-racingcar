package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/09
 * @description :
 **/
public class LapHistory {
	private List<CarHistory> carHistories;

	public LapHistory() {
		this.carHistories = new ArrayList<>();
	}

	public void add(CarHistory carHistory) {
		carHistories.add(carHistory);
	}

	public List<CarHistory> get() {
		return carHistories;
	}
}
