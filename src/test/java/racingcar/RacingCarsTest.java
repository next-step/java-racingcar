package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

class RacingCarsTest {
	private static final int INITIAL_POSITION = 0;
	private static final int POSITION_AFTER_ONE_MOVE = 1;
	RacingCars racingCars;

	@BeforeEach
	void setUp() {
		racingCars = new RacingCars(new String[]{"chang", "sub", "kwak"}, () -> true);
	}

	@Test
	void 자동차그룹을_전부_forward하는_forwardCars를_호출하면_모든_자동차가_이동한다() {
		// given
		List<RacingCar> racingCarList = racingCars.getCars();

		// check given data
		for (int i = 0 ; i < racingCarList.size() ; i++) {
			assertThat(racingCarList.get(i).getPosition()).isEqualTo(INITIAL_POSITION);
		}

		// when
		racingCars.forwardCars();

		// then
		for (int i = 0 ; i < racingCarList.size() ; i++) {
			assertThat(racingCarList.get(i).getPosition()).isEqualTo(POSITION_AFTER_ONE_MOVE);
		}
	}

	@ParameterizedTest
	@MethodSource
	void 생성자를_호출하였을_때_초기값_0으로_위치값이_세팅된다(String[] carNames) {
		racingCars = new RacingCars(carNames, () -> true);
		racingCars.getCars().stream().forEach(racingCar -> {
			assertThat(racingCar.getPosition()).isEqualTo(INITIAL_POSITION);
		});
	}

	private static Stream<Arguments> 생성자를_호출하였을_때_초기값_0으로_위치값이_세팅된다() {
		return Stream.of(
			Arguments.of(
				(Object) new String[] {"chang"}
			),
			Arguments.of(
				(Object) new String[] {"chang", "sub"}
			),
			Arguments.of(
				(Object) new String[] {"chang", "sub", "kwak", "bravo"}
			)
		);
	}

	@Test
	void 모든_자동차들의_전진함수가_호출된다면_모든_자동차들은_한_칸씩_전진한다() {
		racingCars.getCars().stream()
			.forEach(racingCar -> {
				racingCar.forward();
			});

		for (int i = 0; i < 3 ; i++) {
			assertThat(racingCars.getCars().get(i).getPosition()).isEqualTo(POSITION_AFTER_ONE_MOVE);
		}
	}


	@ParameterizedTest
	@MethodSource
	void 전진횟수와_자동차이름이_주어지고_항상전진전략을_가지는_자동차그룹이_있을때_우승자를_예측한다(
			String[] carNames, Integer[] forwardIterationNumber, String expected
	) {
		racingCars = new RacingCars(carNames, () -> true);
		for (int i = 0; i < carNames.length ; i++) {
			iterateForward(racingCars.getCars().get(i), forwardIterationNumber[i]);
		}

		String winners = racingCars.getWinners().toString();
		System.out.println(winners);
		assertThat(winners.substring(1, winners.length() - 1)).isEqualTo(expected);
	}

	private static void iterateForward(RacingCar racingCar, int iterationCount) {
		for(int i = 0; i < iterationCount; i++) {
			racingCar.forward();
		}
	}

	private static Stream<Arguments> 전진횟수와_자동차이름이_주어지고_항상전진전략을_가지는_자동차그룹이_있을때_우승자를_예측한다() {
		return Stream.of(
				Arguments.of(
						new String[] {"chang", "sub", "kwak"},
						new Integer[] {3, 5, 3},
						"sub"
				),
				Arguments.of(
						new String[] {"pobi", "crong", "honux"},
						new Integer[] {5, 5, 3},
						"pobi, crong"
				),
				Arguments.of(
						new String[] {"red", "green", "blue"},
						new Integer[] {5, 5, 5},
						"red, green, blue"
				)
		);
	}

	@Test
	void 길이가_5이하의_자동차이름_문자열이_주어질_때_주어진_문자열_개수만큼_position값이_0인_RacingCar_클래스가_생성된다() {
		String[] carNames = { "five", "chang", "long" };
		RacingCars racingCars = new RacingCars(carNames, () -> false);

		int[] positions = racingCars.getCars()
				.stream()
				.mapToInt(racingCar -> racingCar.getPosition())
				.toArray();

		assertThat(racingCars.getRacingCarsNumber()).isEqualTo(carNames.length);
		assertThat(positions).containsExactly(INITIAL_POSITION, INITIAL_POSITION, INITIAL_POSITION);
	}
}
