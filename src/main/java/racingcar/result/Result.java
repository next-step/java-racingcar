package racingcar.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.domain.Cars;
import racingcar.dto.CarDto;

public class Result {

	private final List<CarDto> carDtos;

	public Result(List<CarDto> carDtos) {
		this.carDtos = new ArrayList<>(carDtos);
	}

	public Result(List<String> names, List<Integer> positions) {
		this(new ArrayList<>());
		for (int i = 0; i < names.size(); ++i) {
			carDtos.add(new CarDto(names.get(i), positions.get(i)));
		}
	}

	public Result(Cars cars) {
		this(cars.getNames(), cars.getPositions());
	}

	public List<CarDto> getCarDtos() {
		return Collections.unmodifiableList(carDtos);
	}
}
