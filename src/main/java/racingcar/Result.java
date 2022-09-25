package racingcar;

import java.util.List;

public class Result {

	private final List<CarDTO> carDTOs;

	public Result(List<CarDTO> carDTOs) {
		this.carDTOs = carDTOs;
	}

	public List<CarDTO> getCarDTOs() {
		return carDTOs;
	}
}
