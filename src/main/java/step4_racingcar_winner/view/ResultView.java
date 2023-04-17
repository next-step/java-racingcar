package step4_racingcar_winner.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step4_racingcar_winner.service.Winner;
import step4_racingcar_winner.dto.CarDTO;

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

	private static void printCarStatus(List<CarDTO> carDTOs) {
		System.out.println();
		for (CarDTO carDTO : carDTOs) {
			System.out.println(formatStatus(carDTO));
		}
	}

	public static String formatStatus(CarDTO carDTO) {
		StringBuilder status = new StringBuilder();
		status.append(carDTO.getName() + " : ");
		for (int i = 0; i < carDTO.getPosition(); i++) {
			status.append("-");
		}
		return status.toString();
	}

	public String printWinner(Winner winner) {
		System.out.println();
		StringBuilder winnerBanner = new StringBuilder();
		winnerBanner.append(winner.getWinner() + lastWinnerBanner);
		return winnerBanner.toString();
	}

	private Map<String, Integer> carDTOsToMap(List<CarDTO> carDTOList) {
		Map<String, Integer> resultMap = new HashMap<>();
		for (CarDTO carDTO : carDTOList) {
			resultMap.put(carDTO.getName(), carDTO.getPosition());
		}
		return resultMap;
	}

}
