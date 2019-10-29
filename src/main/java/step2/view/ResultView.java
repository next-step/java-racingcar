package step2.view;

import step2.dto.CarRaceSnapshot;
import step2.dto.CarDto;
import step2.dto.CarRaceWinnerNames;

import java.util.List;

public class ResultView {

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
		StringBuilder finalResult = join(carRaceWinnerNames.get());
		finalResult.append("가 최종 우승했습니다.");
		System.out.println(finalResult.toString());
	}

	private StringBuilder join(List<String> carNames) {
		StringBuilder stringBuilder = new StringBuilder();
		int end = carNames.size() - 1;
		for (int i = 0; i < end; i++) {
			stringBuilder.append(carNames.get(i));
			stringBuilder.append(",");
		}
		stringBuilder.append(carNames.get(end));
		return stringBuilder;
	}

}
