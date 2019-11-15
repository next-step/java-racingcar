package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

	private RacingGame racingGame;
	private Participants participants;

	@BeforeEach
	void before() {
		racingGame = new RacingGame();
		participants = new Participants();
		participants.register(new String[]{"a", "b", "c"});
	}

	@Test
	void doTurn() {
		assertThat(racingGame.doTurn(participants))
				.isEqualTo(participants);
	}
}
