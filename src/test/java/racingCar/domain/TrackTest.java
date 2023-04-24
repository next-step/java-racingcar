package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrackTest {

	private Track track;

	@BeforeEach
	void setUp() {
		track = Track.create();
	}

	@Test
	@DisplayName("우승 레이싱카를 찾는 기능을 테스트한다")
	void test_find_winners() {
		Car car1 = new Car("car1", 0, Distance.from(0));
		Car car2 = new Car("car2", 0, Distance.from(1));
		Car car3 = new Car("car3", 0, Distance.from(2));
		Car car4 = new Car("car4", 0, Distance.from(2));

		track.putRaceCar(car1, car2, car3, car4);

		List<Car> winners = track.findWinners();

		assertThat(winners).isEqualTo(List.of(car3, car4));
	}
}
