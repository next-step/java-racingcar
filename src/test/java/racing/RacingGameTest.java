package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.object.Car;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	private static Stream<Arguments> getValidCase() {
		List<Arguments> argumentsList = new ArrayList<>();
		argumentsList.add(Arguments.of(new String[]{"test1","test2","test3"},"5"));
		return argumentsList.stream();
	}

	@DisplayName("1. 자동차 객체 생성 확인")
	@ParameterizedTest
	@MethodSource("getValidCase")
	void checkInitialization(String[] cars, int times) {
		final int INIT_POS = 0;
		RacingGame game = new RacingGame(cars, times);
		Car car = null;
		for (int i = 0; i < cars.length; ++i) {
			car = game.getCarList().get(i);
			assertThat(car.getName()).isEqualTo(cars[i]);
			assertThat(car.getPosition()).isEqualTo(INIT_POS);
		}
	}

	@DisplayName("2. 자동차 경주 진행 확인")
	@ParameterizedTest
	@MethodSource("getValidCase")
	void checkMove(String[] cars, int times) {
		RacingGame game = new RacingGame(cars, times);
		for ( int i = 0; game.isInTime(i); ++i ) {
			assertThat(game.move().stream().map(Car::getPosition)).isNotEqualTo(0);
		}
	}
	
	@DisplayName("3. 최종 우승자 확인")
	@ParameterizedTest
	@MethodSource("getValidCase")
	void checkWinner(String[] cars, int times) {
		RacingGame game = new RacingGame(cars, times);
		assertThat(game.getWinner().size()).isGreaterThan(0);
	}
}
