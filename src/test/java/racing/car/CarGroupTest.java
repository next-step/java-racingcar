package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.TestUtils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1", "999,999"})
	void getMoveForwardChance(int carNum, int expectedCallCount) {
		// given
		Counter moveForwardCallCounter = new Counter();
		List<String> carNameList = TestUtils.createAnyCarNameList(carNum);
		CarGroup carGroup = CarGroup.of(carNameList, createStrategyForCallCount(moveForwardCallCounter));

		// when
		carGroup.getMoveForwardChance();

		// then
		assertThat(moveForwardCallCounter.getCount()).isEqualTo(expectedCallCount);
	}

	@Test
	@DisplayName("모두가 안움직일때 우승자 이름 리스트를 확인")
	void getWinnerList_모두공동1위_안움직임() {
		// given
		Car notMoved1 = createNotMovedCar("win1");
		Car notMoved2 = createNotMovedCar("win2");
		Car notMoved3 = createNotMovedCar("win3");
		CarGroup carGroup = new CarGroup(Arrays.asList(notMoved1, notMoved2, notMoved3));

		// when
		carGroup.getMoveForwardChance();
		List<String> winnerNameList = carGroup.getWinnerNameList();

		// then
		assertThat(winnerNameList).containsExactlyInAnyOrder("win1", "win2", "win3");
	}

	@Test
	@DisplayName("모두가 움직일때 우승자 이름 리스트를 확인")
	void getWinnerList_모두공동1위_무조건움직임() {
		// given
		Car moved1 = createAlwaysMovedCar("win1");
		Car moved2 = createAlwaysMovedCar("win2");
		Car moved3 = createAlwaysMovedCar("win3");
		CarGroup carGroup = new CarGroup(Arrays.asList(moved1, moved2, moved3));

		// when
		carGroup.getMoveForwardChance();
		List<String> winnerNameList = carGroup.getWinnerNameList();

		// then
		assertThat(winnerNameList).containsExactlyInAnyOrder("win1", "win2", "win3");
	}

	@Test
	@DisplayName("한명만 움직일때 우승자 이름 리스트를 확인")
	void getWinnerList_한명만움직임() {
		// given
		Car moved1 = createAlwaysMovedCar("win1");
		Car notMoved1 = createNotMovedCar("loose1");
		Car notMoved2 = createNotMovedCar("loose2");
		CarGroup carGroup = new CarGroup(Arrays.asList(moved1, notMoved1, notMoved2));

		// when
		carGroup.getMoveForwardChance();
		List<String> winnerNameList = carGroup.getWinnerNameList();

		// then
		assertThat(winnerNameList).containsExactly("win1");
	}

	private Car createNotMovedCar(String name) {
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

		return new Car(name, notMoveStrategy);
	}

	private Car createAlwaysMovedCar(String name) {
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

		return new Car(name, alwaysMoveStrategy);
	}

	private static MoveForwardStrategy createStrategyForCallCount(Counter counter) {
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

	private static class Counter {
		private int count;

		Counter() {
			count = 0;
		}

		void addCount() {
			count++;
		}

		int getCount() {
			return count;
		}
	}
}