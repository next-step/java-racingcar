package study.racingcar;

public class OutputView {
	public void printRacingResult(RacingResult racingResult) {
		racingResult.getResults()
			.forEach(this::printCarResult);
		System.out.println();

	}

	public void printCarResult(Integer count) {
		for (int i = 0; i <= count; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
