package racing;

import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	private static final int RACING_CAR_COUNT = 3;
	private static final int PLAY_COUNT = 5;

	RacingGame racingGame = new RacingGame();

	@Test
	void 경주에_출전한_차_댓수와_돌아야하는_카운트도_잘도는지_테스트(){
		List<Car> cars = racingGame.prepareInitRacingCar(RACING_CAR_COUNT);
		assertThat(cars).hasSize(RACING_CAR_COUNT);

		racingGame.startRacing(cars, PLAY_COUNT);

		for(Car car : cars){
			assertThat(car.getRacingRecord()==PLAY_COUNT).isTrue();
		}
	}

}