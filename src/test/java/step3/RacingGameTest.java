package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

	@Test
	void registParticipants() {
		RacingGame racingGame = new RacingGame();
		String[] participantNames = new String[] {"a", "b", "c"};
		assertThat(racingGame.registParticipants(participantNames))
				.contains(new Car("a"), new Car("b"), new Car("c"));
	}

}