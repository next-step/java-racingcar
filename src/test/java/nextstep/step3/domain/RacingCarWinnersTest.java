package nextstep.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarWinnersTest {
	private RacingCarWinners underTest = new RacingCarWinners();
	@Test
	@DisplayName("레이싱에 우승한 자동차명을 얻을수 있다.")
	public void racingCarWinnersTest() {
		List<String> winners = underTest.getRacingWinnerNames(mockRacingCars());
		assertThat(String.join(",", winners)).isEqualTo("adel,ruby");
	}

	private List<RacingCar> mockRacingCars() {
		RacingCar racingCar1 = new RacingCar("adel");
		racingCar1.move(5);
		RacingCar racingCar2 = new RacingCar("joy");
		racingCar2.move(2);
		RacingCar racingCar3 = new RacingCar("ruby");
		racingCar3.move(5);
		return Arrays.asList(racingCar1, racingCar2, racingCar3);
	}
}
