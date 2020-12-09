package racing.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.TestUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {


	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1", "999,999"})
	void getMoveForwardChance(int carNum, int expectedCallCount) {
		// given
		Counter moveForwardCallCounter = new Counter();
		List<String> carNameList = TestUtils.createAnyCarNameList(carNum);
		CarGroup carGroup = new CarGroup(carNameList, createStrategyForCallCount(moveForwardCallCounter));

		// when
		carGroup.getMoveForwardChance();

		// then
		assertThat(moveForwardCallCounter.getCount()).isEqualTo(expectedCallCount);
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