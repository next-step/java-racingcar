package step4_racingcar_winner.view;

import java.util.List;

import step4_racingcar_winner.dto.CarDTO;

public class ResultView {

	private static void printCarStatus(List<CarDTO> carDTOs) {
		System.out.println();
		for (CarDTO carDTO : carDTOs) {
			System.out.println(formatStatus(carDTO));
		}
	}

	public void printResult(List<List<CarDTO>> results) {
		for (List<CarDTO> roundResult : results) {
			printCarStatus(roundResult);
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
}
