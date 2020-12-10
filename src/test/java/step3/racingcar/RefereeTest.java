package step3.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.RacingCars;
import step3.racingcar.domain.Referee;

public class RefereeTest {

	private RacingCars racingCars;

	@BeforeEach
	public void setup() {
		racingCars = new RacingCars(Stream.of(
			new RacingCar("hong", 5),
			new RacingCar("pobi", 3),
			new RacingCar("lee", 5)
		).collect(Collectors.toList()));
	}

	@DisplayName("자동차 경주 결과 최고점 구하기")
	@Test
	void given_racing_cars_when_get_max_movedistance_then_return_max_movedistance() {
		Referee referee = new Referee(racingCars);
		assertThat(referee.getMaxMoveDistance()).isEqualTo(5);
	}

	@DisplayName("자동차 경주 우승자 구하기")
	@Test
	void given_racing_cars_when_referee_get_winners_then_return_winner_racing_cars() {
		Referee referee = new Referee(racingCars);
		RacingCars winnerRacingCars = referee.getWinners();
		assertThat(winnerRacingCars.getRacingCars()).containsAnyOf(this.racingCars.getRacingCars().get(0),
			this.racingCars.getRacingCars()
				.get(2));
	}

}
