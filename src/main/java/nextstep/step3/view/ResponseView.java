package nextstep.step3.view;

import nextstep.step3.domain.RacingCars;

import java.util.stream.IntStream;

public class ResponseView {
	private static final String MOVE_TAB = "-";

	public void showRacingResult(RacingCars racingCars) {
		StringBuilder sb = new StringBuilder();
		racingCars.getRacingCars().forEach(car -> {
							sb.append(printRacingPoint(car.getPoint()));
							sb.append("\n");
						}
				);
		System.out.println(sb.toString());
	}

	private String printRacingPoint(int point) {
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, point)
				.forEach(i -> sb.append(MOVE_TAB));
		return sb.toString();
	}

}
