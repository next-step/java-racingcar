package carrase;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	final String name = "TEST";

	@Test
	@DisplayName("자동차 전진")
	void carMove() {
		RacingCar car = new RacingCar(name);
		car.moveForward();

		assertThat(car.getMileage()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 멈춤")
	void carStop() {
		RacingCar car = new RacingCar(name);
		car.stop();

		assertThat(car.getMileage()).isEqualTo(0);
	}

	@Test
	@DisplayName("전진")
	void move() {
		CarBehavior carBehavior = CarBehavior.getCarBehavior(4);
		RacingCar car = new RacingCar(name);
		carBehavior.apply(car);

		assertThat(car.getMileage()).isEqualTo(1);
	}

	@Test
	@DisplayName("멈춤")
	void stop() {
		CarBehavior carBehavior = CarBehavior.getCarBehavior(3);
		RacingCar car = new RacingCar(name);
		carBehavior.apply(car);

		assertThat(car.getMileage()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차 이름은 5자를 초과할 수 없다")
	void notExceedCarNameLengthFive() {
		assertThatThrownBy(() -> {
			new RacingCar("longName");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다")
	void printCarName() {
		List<String> sampleName = Arrays.asList("pobi", "crong", "honux");
		CarRacingGame game = new CarRacingGame(sampleName);
		game.start();
		assertThat(game.getGameResult()).containsKeys(sampleName.stream().toArray(String[]::new));
	}
}
