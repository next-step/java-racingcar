package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.rule.FixedTrueMoveRule;
import racingcar.rule.MoveRule;

class RacingGameTest {
	private static final MoveRule MOVE_RULE = new FixedTrueMoveRule();
	private static final int DEFAULT_NUMBER_OF_ROUNDS = 3;
	private static final int DEFAULT_NUMBER_OF_CARS = 3;

	@DisplayName("유효한 파라미터 객체 생성 검증")
	@ParameterizedTest(name = "{index}. numberOfRounds : {0}, numberOfCars : {1}")
	@CsvSource({"1,1", "3,3", "4,4", "5,5"})
	void create(int numberOfRounds, int numberOfCars) {
		// when
		RacingGame racingGame = RacingGame.create(MOVE_RULE, numberOfRounds, numberOfCars);

		// then
		assertThat(racingGame).isNotNull();
	}

	@DisplayName("유효하지 않은 파라미터 객체 생성 검증")
	@ParameterizedTest(name = "{index}. numberOfRounds : {0}, numberOfCars : {1}")
	@CsvSource({"-1,1", "-3,3", "-4,-4", "0,5"})
	void createWithInvalidArguments(int numberOfRounds, int numberOfCars) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> RacingGame.create(MOVE_RULE, numberOfRounds, numberOfCars));
	}

	@DisplayName("움직이지 않을 경우 다음 라운드가 남아 있는지 검증")
	@Test
	void hasNextRound() {
		// given
		RacingGame racingGame = createDefaultRacingGame();

		// when
		boolean result = racingGame.hasNextRound();

		// then
		assertThat(result).isTrue();
	}

	@DisplayName("한번 이동하는 메서드 검증")
	@Test
	void moveOnce() {
		// given
		RacingGame racingGame = createDefaultRacingGame();

		// when
		racingGame.moveOnce();

		// then
		assertThat(racingGame).isEqualTo(createMovedOnceRacingGame());
	}

	private RacingGame createDefaultRacingGame() {
		return RacingGame.create(MOVE_RULE, DEFAULT_NUMBER_OF_ROUNDS, DEFAULT_NUMBER_OF_CARS);
	}

	private RacingGame createMovedOnceRacingGame() {
		List<Car> expectedCars = new ArrayList<>();
		for (int i = 0; i < DEFAULT_NUMBER_OF_ROUNDS; i++) {
			expectedCars.add(new Car(new Position(Position.DEFAULT_POSITION + 1)));
		}
		Round round = new Round(Round.FIRST_ROUND + 1, DEFAULT_NUMBER_OF_ROUNDS);
		return new RacingGame(MOVE_RULE, round, Cars.create(expectedCars));
	}

}