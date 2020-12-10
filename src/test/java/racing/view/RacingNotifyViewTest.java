package racing.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.TestUtils;
import racing.car.RacingCarGroup;
import racing.car.RandomMoveChanceGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingNotifyViewTest {

	private RacingNotifyView racingNotifyView;

	@BeforeEach
	void setUp() {
		racingNotifyView = new RacingNotifyView();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 999})
	@DisplayName("현재 레이스의 상태를 표시할 때 exception 이 나지 않는지 체크")
	void notifyRace(int carNum) {
		// given
		RacingCarGroup racingCarGroup = RacingCarGroup.of(TestUtils.createAnyCarNameList(carNum), new RandomMoveChanceGenerator());

		// when
		racingCarGroup.getMoveForwardChance();
		racingCarGroup.getMoveForwardChance();
		racingCarGroup.getMoveForwardChance();
		racingNotifyView.notifyRace(racingCarGroup);
	}

	@ParameterizedTest
	@MethodSource(value = "generateParam_notifyWinner")
	@DisplayName("현재 레이스의 승리자를 표시할 때 exception 이 나지 않는지 체크")
	void notifyWinner(List<String> winnerNameList) {
		// when
		racingNotifyView.notifyWinner(winnerNameList);
	}

	@Test
	@DisplayName("현재 레이스의 승리자를 표시할 때 빈 리스트를 받을 경우 테스트")
	void notifyWinner_emptyList() {
		// given
		List<String> empty = Collections.emptyList();

		// when
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> notifyWinner(empty));
	}

	private static Stream<Arguments> generateParam_notifyWinner() {
		return Stream.of(
				Arguments.of(Collections.singletonList("peter")),
				Arguments.of(Arrays.asList("peter", "tearight"))
		);
	}

}