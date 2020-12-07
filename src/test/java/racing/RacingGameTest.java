package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 9})
	@DisplayName("매 진행이 끝날때마다 자동차 경주상황을 전달받아야 한다.")
	void start_notifyGameStatus(int turn) {
		// given
		final NotifyCounter notifyCounter = new NotifyCounter();
		RacingNotifier racingNotifier = racingStatus -> notifyCounter.addCount();
		RacingGame racingGame = new RacingGame(turn, racingNotifier);

		// when
		racingGame.start();

		// then
		assertThat(notifyCounter.getCount()).isEqualTo(turn);
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
