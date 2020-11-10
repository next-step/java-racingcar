package nextstep.step3.view;

import nextstep.step3.domain.RacingCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ResultViewTest {
	private ResultView underTest = new ResultView();

	@Test
	@DisplayName("차 이름별 이동거리를 표시한다.")
	public void resultViewTest() {
		RacingCars racingCars = new RacingCars(Arrays.asList("adel,joy,frisk"));
		racingCars.getRacingCars().forEach(car -> car.move(5));
		underTest.showRacingResult(racingCars);
	}

	@Test
	@DisplayName("최종 우승자들을 출력한다.")
	public void resultWinnderTest() {
		underTest.printRacingWinner(Arrays.asList("adel", "joy"));
	}
}
