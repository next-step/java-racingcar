package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.CarGroup;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 2, 5})
	@DisplayName("차량 대수를 입력받고 그 차량 수 만큼 자동차 경주를 진행")
	void start_carNum(int carNum) {
		// given
		List<String> anyCarNameList = TestUtils.createAnyCarNameList(carNum);
		RacingGame racingGame = new RacingGame(anyCarNameList, 5, createEmptyRacingNotifier());

		// when
		CarGroup carGroup = racingGame.start();

		// then
		assertThat(carGroup.stream()).hasSize(carNum);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 9})
	@DisplayName("매 진행이 끝날때마다 자동차 경주상황을 전달받아야 한다.")
	void start_notifyGameStatus(int turn) {
		// given
		final NotifyCounter notifyCounter = new NotifyCounter();
		RacingNotifier racingNotifier = new RacingNotifier() {
			@Override
			public void notifyRace(CarGroup carGroup) {
				notifyCounter.addCount();
			}

			@Override
			public void notifyWinner(List<String> winnerNameList) {
				// do nothing;
			}
		};

		RacingGame racingGame = new RacingGame(Collections.emptyList(), turn, racingNotifier);

		// when
		racingGame.start();

		// then
		assertThat(notifyCounter.getCount()).isEqualTo(turn);
	}

	private static RacingNotifier createEmptyRacingNotifier() {
		return new RacingNotifier() {
			@Override
			public void notifyRace(CarGroup carGroup) {

			}

			@Override
			public void notifyWinner(List<String> winnerNameList) {

			}
		};
	}

	/**
	 * Racing turn 횟수 카운터
	 */
	private static class NotifyCounter {
		private int count;

		NotifyCounter() {
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
