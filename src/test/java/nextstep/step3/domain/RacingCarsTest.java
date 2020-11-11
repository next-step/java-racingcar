package nextstep.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarsTest {
	@Test
	@DisplayName("자동차수만큼 레이싱카를 만든다.")
	public void racingCarsTest() {
		RacingCars racingCars = new RacingCars("adel,joy,ruby");
		assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
	}

	@Test
	@DisplayName("레이싱에 우승한 자동차명을 얻을수 있다.")
	public void racingCarWinnersTest() {
		RacingCars racingCars = new RacingCars("adel,joy,ruby");
		int point = 1;
		for (RacingCar car : racingCars.getRacingCars()) {
			car.move(++point);
		}
		List<String> winners = racingCars.getRacingWinnerNames();
		assertThat(String.join(",", winners)).isEqualTo("ruby");
	}

	@Test
	@DisplayName("자동차 이름을 가져온다.")
	public void getCarNamesTest() {
		RacingCars racingCars = new RacingCars("adel,joy,ruby,angus,shawn");

		assertThat(racingCars.getCarNames().size()).isEqualTo(5);
		assertTrue(racingCars.getCarNames().contains("adel"));
		assertTrue(racingCars.getCarNames().contains("joy"));
		assertTrue(racingCars.getCarNames().contains("ruby"));
		assertTrue(racingCars.getCarNames().contains("angus"));
		assertTrue(racingCars.getCarNames().contains("shawn"));
	}
}
