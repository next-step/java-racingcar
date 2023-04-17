package step3_racingcar.view;

import java.util.List;

import step3_racingcar.domain.Car;
import step3_racingcar.dto.CarDTO;
import step3_racingcar.service.CarStatus;

public class ResultView {

	private static void printCarStatus(List<CarDTO> carDTOs) {
		System.out.println();
		for (CarDTO carDTO : carDTOs) {
			System.out.println(CarStatus.formatStatus(carDTO.getPosition()));
		}
	}

	public void printResult(List<List<CarDTO>> results) {
		for (List<CarDTO> roundResult : results) {
			printCarStatus(roundResult);
		}
	}
}
