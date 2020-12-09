package racingCar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : byungkyu
 * @date : 2020/12/08
 * @description :
 **/
public class RaceHistory {
	private List<LapHistory> carHistories;

	public RaceHistory() {
		this.carHistories = new ArrayList<>();
	}

	public int getCount() {
		return carHistories.size();
	}

	public List<LapHistory> get() {
		return carHistories;
	}


	public void add(LapHistory lapHistory) {
		carHistories.add(lapHistory);
	}
}
