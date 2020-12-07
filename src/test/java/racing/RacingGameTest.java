package racing;

import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.Forward;
import racing.model.Stop;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	RacingGame racingGame = new RacingGame();

	//todo Refactoring
	//실질 로직을 테스트하는 건 prepareInitRacingCar만 유효함. UI 기능은 테스트X
	@Test
	void 경주에_출전한_차_댓수와_전진멈춤_테스트_테스트() {
		String inputName = "a, bb, ccc, dddd";
		List<Car> cars = racingGame.prepareInitRacingCar(inputName);
		assertThat(cars.size()).isEqualTo(inputName.split(",").length);

		for (Car car : cars) {
			car.speedUp(new Stop());
			assertThat(car.getForwardPosition()).isEqualTo(0);
		}
		for (Car car : cars) {
			car.speedUp(new Forward());
			assertThat(car.getForwardPosition()).isEqualTo(1);
		}
		for (Car car : cars) {
			car.speedUp(new Forward());
			assertThat(car.getForwardPosition()).isEqualTo(2);
		}
		for (Car car : cars) {
			car.speedUp(new Stop());
			assertThat(car.getForwardPosition()).isEqualTo(2);
		}

	}

}