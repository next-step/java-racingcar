package racing;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.CarName;
import racing.car.RacingCarGroup;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingGameTest {

	@ParameterizedTest
	@ValueSource(ints = {-9, 0})
	@DisplayName("차량 이름 리스트 입력받을때 사이즈가 0, 음수일경우 생성 실패")
	void constructor_fail(int carNum) {
		// given
		List<CarName> anyCarNameList = TestUtils.createAnyCarNameList(carNum);

		// when
		ThrowableAssert.ThrowingCallable callable = () -> new RacingGame(anyCarNameList, 5, createEmptyRacingNotifier());

		// when & then
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(callable);
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 5})
	@DisplayName("차량 대수를 입력받고 그 차량 수 만큼 자동차 경주를 진행")
	void start_carNum(int carNum) {
		// given
		List<CarName> anyCarNameList = TestUtils.createAnyCarNameList(carNum);
		RacingGame racingGame = new RacingGame(anyCarNameList, 5, createEmptyRacingNotifier());

		// when
		RacingCarGroup racingCarGroup = racingGame.start();

		// then
		assertThat(racingCarGroup.size()).isEqualTo(carNum);
	}

	@ParameterizedTest
	@ValueSource(ints = {5, 9})
	@DisplayName("매 진행이 끝날때마다 자동차 경주상황을 전달받아야 한다.")
	void start_notifyGameStatus(int turn) {
		// given
		final TestUtils.Counter notifyCounter = new TestUtils.Counter();
		RacingNotifier racingNotifier = new RacingNotifier() {
			@Override
			public void notifyRace(RacingCarGroup carGroup) {
				notifyCounter.addCount();
			}

			@Override
			public void notifyWinner(List<CarName> winnerNameList) {
				// do nothing;
			}
		};

		RacingGame racingGame = new RacingGame(Collections.singletonList(new CarName("hi")), turn, racingNotifier);

		// when
		racingGame.start();

		// then
		assertThat(notifyCounter.getCount()).isEqualTo(turn);
	}

	private static RacingNotifier createEmptyRacingNotifier() {
		return new RacingNotifier() {
			@Override
			public void notifyRace(RacingCarGroup racingCarGroup) {

			}

			@Override
			public void notifyWinner(List<CarName> winnerNameList) {

			}
		};
	}
}
