package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.rule.FixedTrueMoveRule;
import racingcar.rule.MoveRule;

class RacingGameTest {
	private static final MoveRule FIXED_TRUE_MOVE_RULE = new FixedTrueMoveRule();
	private static final String DEFAULT_NAME_OF_CARS = "aCar,bCar,cCar";
	private static final int DEFAULT_NUMBER_OF_ROUNDS = 3;

	private static final int LAST_POSITION = 3;
	private static final int LAST_ROUND = 3;

	@DisplayName("유효한 파라미터 객체 생성 검증")
	@ParameterizedTest(name = "{index}. nameOfCars : {0}, numberOfCars : {1}")
	@CsvSource(value = {"a:1", "a,b:3", "a,b,c:4", "a,b,c,d:5"}, delimiter = ':')
	void create(String nameOfCars, int numberOfRounds) {
		// when
		RacingGame racingGame = RacingGame.create(FIXED_TRUE_MOVE_RULE, nameOfCars, numberOfRounds);

		// then
		assertThat(racingGame).isNotNull();
	}

	@DisplayName("유효하지 않은 파라미터 객체 생성 검증")
	@ParameterizedTest(name = "{index}. nameOfCars : {0}, numberOfCars : {1}")
	@CsvSource(value = {":1", "a:-1", "a,b:0"}, delimiter = ':')
	void createWithInvalidArguments(String nameOfCars, int numberOfRounds) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> RacingGame.create(FIXED_TRUE_MOVE_RULE, nameOfCars, numberOfRounds));
	}

	@DisplayName("움직이지 않을 경우 다음 라운드가 남아 있는지 검증")
	@Test
	void hasNextRound() {
		// given
		RacingGame racingGame = createNotMovedRacingGame();

		// when
		boolean result = racingGame.hasNextRound();

		// then
		assertThat(result).isTrue();
	}

	@DisplayName("마지막 라운드일 경우 다음라운드가 남아 있는지 검증")
	@Test
	void hasNextRoundWhenLastRound() {
		// given
		RacingGame racingGame = createRacingGame(LAST_POSITION, LAST_ROUND);

		// when
		boolean result = racingGame.hasNextRound();

		// then
		assertThat(result).isFalse();
	}

	@DisplayName("한번 이동하는 메서드 검증")
	@Test
	void moveOnce() {
		// given
		RacingGame racingGame = createNotMovedRacingGame();

		// when
		racingGame.moveOnce();

		// then
		assertThat(racingGame).isEqualTo(createMovedOnceRacingGame());
	}

	@DisplayName("마지막 라운드일때 모두 포지션이 같을 경우 우승자도 모두 같은지 검증")
	@Test
	void getWinnerNames() {
		// given
		RacingGame racingGame = createRacingGame(LAST_POSITION, LAST_ROUND);
		String[] expectedNames = DEFAULT_NAME_OF_CARS.split(Cars.NAME_OF_CARS_DELIMITER);

		// when
		List<String> winnerNames = racingGame.getWinnerNames();

		// then
		assertThat(winnerNames).hasSize(expectedNames.length);
		assertThat(winnerNames).hasSameElementsAs(Arrays.asList(expectedNames));
	}

	@DisplayName("마지막 라운드가 아닐 경우 우승자 조회 호출시 예외 발생")
	@Test
	void getWinnerNamesException() {
		// given
		RacingGame racingGame = createNotMovedRacingGame();

		// when then
		assertThatIllegalStateException()
			.isThrownBy(racingGame::getWinnerNames);
	}

	private RacingGame createNotMovedRacingGame() {
		return RacingGame.create(FIXED_TRUE_MOVE_RULE, DEFAULT_NAME_OF_CARS, DEFAULT_NUMBER_OF_ROUNDS);
	}

	private RacingGame createMovedOnceRacingGame() {
		return createRacingGame(1, 1);
	}

	private RacingGame createRacingGame(int currentPosition, int currentRound) {
		List<Car> cars = new ArrayList<>();

		String[] names = DEFAULT_NAME_OF_CARS.split(Cars.NAME_OF_CARS_DELIMITER);
		for (String name : names) {
			cars.add(new Car(name, new Position(Position.DEFAULT_POSITION + currentPosition)));
		}

		Round round = new Round(Round.INITIAL_ROUND + currentRound, DEFAULT_NUMBER_OF_ROUNDS);
		return new RacingGame(FIXED_TRUE_MOVE_RULE, Cars.create(cars), round);
	}
}
