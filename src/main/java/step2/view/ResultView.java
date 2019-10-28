package step2.view;

import step2.domain.CarRaceSnapshot;

public class ResultView {

	public void printVisualizedCarRacing(CarRaceSnapshot carRaceSnapshot) {
		for (int carStep : carRaceSnapshot.getSnapshot()) {
			System.out.println(visualizeCarStep(carStep));
		}
		System.out.println();
	}

	private String visualizeCarStep(int step) {
		StringBuilder visualizedCarStep = new StringBuilder();
		for (int i = 0; i < step; i++) {
			visualizedCarStep.append("-");
		}
		return visualizedCarStep.toString();
	}

}
