package racingcar.view;

import racingcar.domain.RankingCars;

public class Result {

	private final RankingCars rankingCars;

	public Result(RankingCars rankingCars) {
		this.rankingCars = rankingCars;
	}

	public void print() {
		rankingCars.results()
			.forEach(System.out::println);
		System.out.println();
	}
}
