package racinggame.dto;

import java.util.List;
import racinggame.domain.Car;
import racinggame.utils.CarGenerator;

public class RacingGameInfo {

	private String carNames;
	private int time;

	public RacingGameInfo(String carNames, int time) {
		this.carNames = carNames;
		this.time = time;
	}

	public List<Car> readyCar() {
		return CarGenerator.generate(carNames);
	}

	public String getCarNames() {
		return carNames;
	}

	public void setCarNames(String carNames) {
		this.carNames = carNames;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
