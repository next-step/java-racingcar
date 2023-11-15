package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.game.RacingGameRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RacingGameRequestTest {
	@Test
	@DisplayName("생성자_int carCount, int tryCount_cars size carCount")
	void 생성자테스트_carCount_tryCount() {
		RacingGameRequest racingGameRequest = new RacingGameRequest(3, 5);
		assertThat(racingGameRequest.cars()).hasSize(3);
	}

	@Test
	@DisplayName("생성자_List<String> carNames, int tryCount_name, distance 값 가진 객체 생성")
	void 생성자테스트_carNames_tryCount() {
		RacingGameRequest racingGameRequest = new RacingGameRequest(List.of("test1", "test2"), 5);
		assertThat(racingGameRequest.cars())
				.extracting(car -> car.carName.carName(), car -> car.distance)
				.contains(tuple("test1", 0), tuple("test2", 0));
	}
}