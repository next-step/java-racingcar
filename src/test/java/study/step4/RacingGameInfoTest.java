package study.step4;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameInfoTest {

	private static final RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
	private Cars participants;

	@BeforeEach
	void setUp() {
		participants = new Cars();

		Car car1 = new Car();
		car1.initPosition();
		participants.add(car1);

		Car car2 = new Car();
		car2.initPosition();
		participants.add(car2);
	}

	@DisplayName("참가자는 racingGameInfo 참가자로 set 된다.")
	@Test
	void Given_Participants_Then_SetParticipants() {
		RacingGameInfo racingGameInfo = new RacingGameInfo();
		racingGameInfo.setParticipants(participants);

		assertThat(racingGameInfo.getParticipants().size()).isEqualTo(participants.size());
	}

	@DisplayName("우승자의 위치와 maxPostion 의 값은 같다.")
	@Test
	void Given_findWinners_Then_ReturnWinners() {
		RacingGameInfo racingGameInfo = new RacingGameInfo();
		racingGameInfo.setParticipants(participants);

		participants.moveAll(randomMoveStrategy);

		int maxPosition = participants.findMaxPosition();
		racingGameInfo.setMaxPosition(maxPosition);

		assertThat(racingGameInfo.findWinners().get(0).getPosition()).isEqualTo(racingGameInfo.getMaxPosition());
	}
}