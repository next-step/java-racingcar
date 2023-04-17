package step3_racingcar.view;

import java.util.List;

import step3_racingcar.dto.CarDTO;

public class ResultView {

	private static void printCarStatus(List<CarDTO> carDTOs) {
		System.out.println();
		for (CarDTO carDTO : carDTOs) {
			System.out.println(formatStatus(carDTO.getPosition()));
		}
	}

	public void printResult(List<List<CarDTO>> results) {
		for (List<CarDTO> roundResult : results) {
			printCarStatus(roundResult);
		}
	}

	public static String formatStatus(int position) {
		StringBuilder status = new StringBuilder();
		for (int i = 0; i < position; i++) {
			status.append("-");
		}
		return status.toString();
	}
}
