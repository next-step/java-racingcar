package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.dto.WinnerDTO;

public final class Winners {
	private List<Car> winners;

	public Winners() {
		winners = new ArrayList<>();
	}

	public List<Car> winners() {
		return winners;
	}

	public void findWinners(final Cars cars) {
		Distance maxDistance = new Distance(0);
		for (int carNum = 0; carNum < cars.size(); carNum++) {
			WinnerDTO winnerDTO = new WinnerDTO(cars, maxDistance, carNum);
			addCarTheSameSpeedAsFastest(winnerDTO);
			maxDistance = new Distance(addFasterCar(winnerDTO));
		}
	}

	private void addCarTheSameSpeedAsFastest(WinnerDTO winnerDTO) {
		if (winnerDTO.cars().car(winnerDTO.carNum()).distance().equals(winnerDTO.maxDistance())) {
			winners.add(winnerDTO.cars().car(winnerDTO.carNum()));
		}
	}

	private int addFasterCar(WinnerDTO winnerDTO) {
		if (winnerDTO.cars().car(winnerDTO.carNum()).distance().compareTo(winnerDTO.maxDistance())) {
			winners = new ArrayList<>();
			winners.add(winnerDTO.cars().car(winnerDTO.carNum()));
			winnerDTO.createMaxDistance(winnerDTO.cars().car(winnerDTO.carNum()).distance());
		}
		return winnerDTO.maxDistance().distance();
	}
}
