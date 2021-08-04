package step3.domain;

import java.util.List;

public class RacingResult {
	private List<Integer> positionOfCars;

	public RacingResult(List<Integer> positions) {
		this.positionOfCars = positions;
	}

	public List<Integer> getPositionOfCars() {
		return positionOfCars;
	}
}