package step3.view;

import java.util.List;

import step3.domain.RacingResult;
import step3.domain.RacingResults;

public class OutputView {
	private static final String MOVE_OUTPUT = "-";

	public static void viewResult(List<RacingResults> results) {
		for (int i = 0; i < results.size(); i++) {
			RacingResults resultOne = results.get(i);
			viewOneTrial(resultOne.getResults());
			System.out.println();
		}
	}

	private static void viewOneTrial(List<RacingResult> cars) {
		for (int i = 0; i < cars.size(); i++) {
			viewOneCar(cars.get(i));
		}
	}

	private static void viewOneCar(RacingResult result) {
		System.out.print(result.getName() + " : ");
		for (int i = 0; i < result.getPosition(); i++) {
			System.out.print(MOVE_OUTPUT);
		}
		System.out.println();
	}

	public static void viewChampion(List<String> names) {
		String champions = String.join(", ", names);
		System.out.println(champions + "가 최종 우승했습니다.");
	}
}