package step2.view;

import step2.dto.CarDto;
import step2.dto.CarRaceSnapshot;
import step2.dto.CarRaceWinnerNames;

public class ResultView {

	private final String delimiter;

	public ResultView(String delimiter) {
		this.delimiter = delimiter;
	}

	public void printVisualizedCarRacing(CarRaceSnapshot carRaceSnapshot) {
		for (CarDto carDto : carRaceSnapshot.getSnapshot()) {
			System.out.println(visualizeCarStep(carDto));
		}
		System.out.println();
	}

	private String visualizeCarStep(CarDto carDto) {
		StringBuilder visualizedCarStep = new StringBuilder(String.format("%s : ", carDto.getName()));
		for (int i = 0; i < carDto.getStep(); i++) {
			visualizedCarStep.append("-");
		}
		return visualizedCarStep.toString();
	}

	public void printFinalResult(CarRaceWinnerNames carRaceWinnerNames) {
		if (carRaceWinnerNames.isEmpty()) {
			System.out.println("우승자가 없습니다!");
			return;
		}
		String finalResult = String.join(delimiter, carRaceWinnerNames.get());
		System.out.println(String.format("%s가 최종 우승했습니다.", finalResult));
	}

}
