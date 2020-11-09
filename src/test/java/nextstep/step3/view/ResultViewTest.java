package nextstep.step3.view;

import nextstep.step3.domain.RacingCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {
	private ResultView underTest = new ResultView();

	@Test
	@DisplayName("차대수별 이동거리를 표시한다.")
	public void resultViewTest() {
		RacingCars racingCars = new RacingCars(3);
		racingCars.getRacingCars().forEach(car -> car.move(5));
		underTest.showRacingResult(racingCars);
	}
}
