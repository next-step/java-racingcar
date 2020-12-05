package racing;

import org.junit.jupiter.api.Test;
import racing.model.RacingCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	private static final int RACING_CAR_COUNT = 3;
	private static final int PLAY_COUNT = 5;

	RacingGame racingGame = new RacingGame();

	@Test
	void 경주에_출전한_차_댓수와_돌아야하는_카운트도_잘도는지_테스트(){
		List<RacingCar> racingCars  = racingGame.prepareInitRacingCar(RACING_CAR_COUNT);
		assertThat(racingCars).hasSize(RACING_CAR_COUNT);

		racingGame.startRacing(racingCars, PLAY_COUNT);

		for(RacingCar racingCar : racingCars){
			assertThat(racingCar.getRacingRecord()==PLAY_COUNT).isTrue();
		}
	}

}