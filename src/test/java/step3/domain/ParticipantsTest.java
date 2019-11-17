package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class ParticipantsTest {

	private Participants participants;

	@BeforeEach
	void before() {
		participants = new Participants(new String[] {"a","b","c"});
	}

	@Test
	void move() {
		assertThat(participants.move(4, 10))
				.isEqualTo(participants.getParticipants());
	}

}