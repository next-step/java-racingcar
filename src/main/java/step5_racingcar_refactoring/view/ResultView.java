package step5_racingcar_refactoring.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step5_racingcar_refactoring.dto.CarDTO;
import step5_racingcar_refactoring.service.Winner;

public class ResultView {
	private static final String lastWinnerBanner = "가 최종 우승했습니다.";

	public void printResult(List<List<CarDTO>> results) {
		Winner winner = new Winner();
		for (List<CarDTO> roundResult : results) {
			printCarStatus(roundResult);
			winner.selectWinner(carDTOsToMap(roundResult));
		}
		System.out.println(printWinner(winner));
	}

	private void printCarStatus(List<CarDTO> cars) {
		System.out.println();
		for (CarDTO car : cars) {
			System.out.println(formatStatus(car));
		}
	}

	public String formatStatus(CarDTO car) {
		StringBuilder status = new StringBuilder();
		status.append(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			status.append("-");
		}
		return status.toString();
	}

	private String printWinner(Winner winner) {
		System.out.println();
		StringBuilder winnerBanner = new StringBuilder();
		winnerBanner.append(printWinnerNames(winner) + lastWinnerBanner);
		return winnerBanner.toString();
	}

	public String printWinnerNames(Winner winner) {
		String winners = String.join(", ", winner.getNames());

		return winners;
	}

	private Map<String, Integer> carDTOsToMap(List<CarDTO> carDTOList) {
		Map<String, Integer> resultMap = new HashMap<>();
		for (CarDTO carDTO : carDTOList) {
			resultMap.put(carDTO.getName(), carDTO.getPosition());
		}
		return resultMap;
	}
}
