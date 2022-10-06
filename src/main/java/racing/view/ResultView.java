package racing.view;

import java.util.stream.IntStream;

import racing.domain.RacingCars;

public class ResultView {

	public ResultView() {
	}

	public void printCarLocations(RacingCars racingCars) {
		IntStream.range(0, racingCars.getRacingCars().size())
			.forEach(i -> {
				printCarLocation(racingCars.getRacingCars().get(i).getLocation());
			});
	}

	private void printCarLocation(int location) {
		IntStream.range(0, location)
			.mapToObj(i -> "-")
			.forEach(System.out::print);
		System.out.println();
	}
}
