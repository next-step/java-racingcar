package step3_racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step3_racingcar.domain.Car;
import step3_racingcar.domain.Cars;
import step3_racingcar.dto.CarDTO;

public class GameProcess {

	public List<List<CarDTO>> play(int tryCount, Cars cars) {
		List<List<CarDTO>> results = new ArrayList<>();

		for (int i = 0; i < tryCount; i++) {
			cars.playRound();
			results.add(CarsToDTO(cars));
		}

		return results;
	}

	private List<CarDTO> CarsToDTO(Cars cars) {
		return cars.getCars().stream()
			.map(car -> new CarDTO(car))
			.collect(Collectors.toList());
	}
}
