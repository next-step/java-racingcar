package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class WinnersTest {

	private Winners winners;
	private Participants participants;

	@BeforeEach
	void before() {
		winners = new Winners();
		participants = new Participants(new String[] {"a","b","c"});
	}

	@Test
	void findWinners() {
		assertThat(winners.findWinners(participants.getParticipants()))
				.contains("a","b","c");
	}

	@Test
	void getMax() {
		assertThat(winners.getMax(participants.getParticipants())).isEqualTo(0);
	}

	@Test
	void getWinners() {
		winners.findWinners(participants.getParticipants());
		assertThat(winners.getWinners()).contains("a","b","c");
	}
}