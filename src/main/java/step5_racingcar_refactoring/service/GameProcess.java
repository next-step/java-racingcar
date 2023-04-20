package step5_racingcar_refactoring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step5_racingcar_refactoring.domain.Car;
import step5_racingcar_refactoring.domain.Cars;

public class GameProcess {

	public List<Cars> play(int tryCount, Cars cars) {
		List<Cars> results = new ArrayList<>();

		for (int i = 0; i < tryCount; i++) {
			cars.playRound();
			results.add(cars.copyCars());
		}

		return results;
	}

}
