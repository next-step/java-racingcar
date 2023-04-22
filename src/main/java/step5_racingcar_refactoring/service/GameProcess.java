package step5_racingcar_refactoring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step5_racingcar_refactoring.dto.CarDTO;
import step5_racingcar_refactoring.domain.Cars;

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
