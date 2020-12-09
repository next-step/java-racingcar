package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.CarGroup;
import racing.car.RandomMoveForwardStrategy;

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
		CarGroup carGroup = new CarGroup(TestUtils.createAnyCarNameList(carNum), new RandomMoveForwardStrategy());

		// when
		racingNotifyView.notifyRace(carGroup);
	}
}