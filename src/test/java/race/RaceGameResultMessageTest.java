package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameResultMessageTest {

	@DisplayName("가장 거리를 멀리간 자동차 결과 테스트")
	@Test
	void 가장_거리를_멀리간_자동차_결과_메세지_TEST() {
		CarGroup carGroup = CarGroup.ofInputValues(InputValue.ofSeparatorValues("pobi,hglee"), new SimpleMovePolicy());

		RaceGameResultMessage resultMessage = new RaceGameResultMessage(1, carGroup);

		assertThat(resultMessage.getDistanceWinner()).isEqualTo("pobi,hglee");

	}
}
