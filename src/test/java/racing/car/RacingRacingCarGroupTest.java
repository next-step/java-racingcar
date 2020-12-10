package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.TestUtils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRacingCarGroupTest {

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1", "999,999"})
	void getMoveForwardChance(int carNum, int expectedCallCount) {
		// given
		TestUtils.Counter moveForwardCallCounter = TestUtils.createCounter();
		List<String> carNameList = TestUtils.createAnyCarNameList(carNum);
		RacingCarGroup racingCarGroup = RacingCarGroup.of(carNameList, createStrategyForCallCount(moveForwardCallCounter));

		// when
		racingCarGroup.getMoveForwardChance();

		// then
		assertThat(moveForwardCallCounter.getCount()).isEqualTo(expectedCallCount);
	}

	@Test
	@DisplayName("모두가 안움직일때 우승자 이름 리스트를 확인")
	void getWinnerList_모두공동1위_안움직임() {
		// given
		RacingCar notMoved1 = createNotMovedCar("win1");
		RacingCar notMoved2 = createNotMovedCar("win2");
		RacingCar notMoved3 = createNotMovedCar("win3");
		RacingCarGroup racingCarGroup = new RacingCarGroup(Arrays.asList(notMoved1, notMoved2, notMoved3));

		// when
		racingCarGroup.getMoveForwardChance();
		List<String> winnerNameList = racingCarGroup.getWinnerNameList();

		// then
		assertThat(winnerNameList).containsExactlyInAnyOrder("win1", "win2", "win3");
	}

	@Test
	@DisplayName("모두가 움직일때 우승자 이름 리스트를 확인")
	void getWinnerList_모두공동1위_무조건움직임() {
		// given
		RacingCar moved1 = createAlwaysMovedCar("win1");
		RacingCar moved2 = createAlwaysMovedCar("win2");
		RacingCar moved3 = createAlwaysMovedCar("win3");
		RacingCarGroup racingCarGroup = new RacingCarGroup(Arrays.asList(moved1, moved2, moved3));

		// when
		racingCarGroup.getMoveForwardChance();
		List<String> winnerNameList = racingCarGroup.getWinnerNameList();

		// then
		assertThat(winnerNameList).containsExactlyInAnyOrder("win1", "win2", "win3");
	}

	@Test
	@DisplayName("한명만 움직일때 우승자 이름 리스트를 확인")
	void getWinnerList_한명만움직임() {
		// given
		RacingCar moved1 = createAlwaysMovedCar("win1");
		RacingCar notMoved1 = createNotMovedCar("loose1");
		RacingCar notMoved2 = createNotMovedCar("loose2");
		RacingCarGroup racingCarGroup = new RacingCarGroup(Arrays.asList(moved1, notMoved1, notMoved2));

		// when
		racingCarGroup.getMoveForwardChance();
		List<String> winnerNameList = racingCarGroup.getWinnerNameList();

		// then
		assertThat(winnerNameList).containsExactly("win1");
	}

	private RacingCar createNotMovedCar(String name) {
		MoveForwardStrategy notMoveStrategy = new MoveForwardStrategy() {
			@Override
			public int createMoveForwardChance() {
				return 0;
			}

			@Override
			public boolean isSatisfiedToMoveForward(int chance) {
				return false;
			}
		};

		return new RacingCar(name, notMoveStrategy);
	}

	private RacingCar createAlwaysMovedCar(String name) {
		MoveForwardStrategy alwaysMoveStrategy = new MoveForwardStrategy() {
			@Override
			public int createMoveForwardChance() {
				return 0;
			}

			@Override
			public boolean isSatisfiedToMoveForward(int chance) {
				return true;
			}
		};

		return new RacingCar(name, alwaysMoveStrategy);
	}

	private static MoveForwardStrategy createStrategyForCallCount(TestUtils.Counter counter) {
		return new MoveForwardStrategy() {
			@Override
			public int createMoveForwardChance() {
				return 0;
			}

			@Override
			public boolean isSatisfiedToMoveForward(int chance) {
				counter.addCount();
				return false;
			}
		};
	}
}