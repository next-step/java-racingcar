package step2.view;

import java.util.List;

public class ResultView {

	public void printVisualizedCarRacing(List<Integer> carRaceSnapshot) {
		for (int carStep : carRaceSnapshot) {
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
