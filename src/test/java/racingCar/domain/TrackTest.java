package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrackTest {
	private Track track;

	@BeforeEach
	void setUp() {
		track = Track.of();
	}

	@Test
	@DisplayName("자동차가 세 대 들어간 하나의 경주 트랙이 주어지고,"
		+ "경기 중이 아닐 때 모든 자동차는 멈춰있어야 한다")
	void stop_all_car() {
		track.putRaceCar(Car.of(), Car.of(), Car.of());

		List<Car> carList = track.getCarList();

		for (Car car : carList) {
			assertThat(car.getSpeed()).isEqualTo(Car.ZERO);
		}
	}

	@Test
	@DisplayName("양수의 속력을 지닌 자동차가 세 대 들어간 하나의 경주 트랙이 주어지고,"
		+ "경주를 시작했을 때 모든 자동차들은 양수의 마일을 이동해야 한다")
	void drive_all_car_positive_mile() {
		Random random = new Random();

		List<Car> givenCarList = new ArrayList<>(Arrays.asList(Car.of(), Car.of(), Car.of()));

		for (Car car : givenCarList) {
			car.accelerate(random.nextInt(Car.MAX_SPEED) + 1);

			track.putRaceCar(car);
		}

		track.raceOnce();

		List<Car> actualCarList = track.getCarList();

		assertThat(actualCarList)
			.allMatch(car -> car.getDistanceList().size() > 0, "모든 자동차는 양수의 마일을 이동해야 한다");
	}
}
