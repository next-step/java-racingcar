package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

	private RacingGame racingGame;

	private String[] participantNames;

	private List<Car> participants;

	@BeforeEach
	void before() {
		racingGame = new RacingGame();

		participantNames = new String[] {"a", "b", "c"};

		participants = new ArrayList<>();
		participants.add(new Car("a"));
		participants.add(new Car("b"));
		participants.add(new Car("c"));
	}

	@Test
	void registerParticipants() {
		assertThat(racingGame.registerParticipants(participantNames))
				.contains(new Car("a"), new Car("b"), new Car("c"));
	}

	@Test
	void doTurn() {
		assertThat(racingGame.doTurn(participants)).isEqualTo(participants);
	}

	@Test
	void findWinner() {
		assertThat(racingGame.findWinner(participants).toArray(new String[] {}))
				.contains("a", "b", "c");
	}

	@Test
	void sortParticipants() {
		assertThat(racingGame.sortParticipants(participants)).isEqualTo(participants);
	}

	@Test
	void getWinners() {
		assertThat(racingGame.getWinners(participants).toArray(new String[] {}))
				.contains("a", "b", "c");
	}

	@Test
	void getMax() {
		assertThat(racingGame.getMax(participants)).isEqualTo(0);
	}
}