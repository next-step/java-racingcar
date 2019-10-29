package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
	RacingGame racingGame;
	private String carName = "pobi,crong,honux";
	private int time = 5;

	@BeforeEach
	void setUp() {
		racingGame = new RacingGame(carName, time);
	}

	@ParameterizedTest
	@CsvSource(value = {"' ':3", "a,b:-1", "'   ': -1"}, delimiter = ':')
	void validateTest(String carName, int time) {
		assertThatThrownBy(() -> {
			new RacingGame(carName, time);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void carNumCompareTest() {
		assertThat(racingGame.getCarList()).hasSize(carName.split(",").length);
	}

	@Test
	void runTest() {
		racingGame.run();
		assertThat(racingGame.getCarList().get(0).getPositionList()).hasSize(time + 1);    // 초기 위치값 저장으로 인해 time + 1과 비교
	}

	@Test
	void winnerCheckTest() {
		racingGame.run();
		int maxPosition = Collections.max(racingGame.getCarList(), Comparator.comparing(car -> car.getPosition())).getPosition();

		racingGame.getCarList().forEach(car -> {
			assertThat(car.getIsWinner()).isEqualTo(car.getPosition() == maxPosition);
		});
	}
}
