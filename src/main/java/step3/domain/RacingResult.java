package step3.domain;

import java.util.List;

public class RacingResult {
	private final int trial;
	private List<Integer> positionOfCars;

	public RacingResult(int trial, List<Integer> positions) {
		this.trial = trial;
		this.positionOfCars = positions;
	}

	public List<Integer> getPositionOfCars() {
		return positionOfCars;
	}
}