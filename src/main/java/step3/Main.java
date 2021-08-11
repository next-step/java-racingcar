package step3;

import java.util.List;

import step3.domain.Racing;
import step3.domain.RacingResults;
import step3.view.InputView;
import step3.view.OutputView;

public class Main {
	public static void main(String[] args) {
		String nameOfCars = InputView.nameOfCars();
		String[] cars = nameOfCars.split(",");

		int trials = InputView.numberOfTrials();

		List<RacingResults> results = Racing.race(trials, cars);
		OutputView.viewResult(results);

		int lastResultIndex = results.size() - 1;
		RacingResults lastResults = results.get(lastResultIndex);

		List<String> champions = lastResults.getChampions();
		OutputView.viewChampion(champions);
	}
}