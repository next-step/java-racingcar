package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class ParticipantsTest {

	private Participants participants;

	@BeforeEach
	void before() {
		participants = new Participants();
	}

	@Test
	void register() {
		assertThat(participants.register(new String[] {"a","b","c"}))
				.contains(new Car("a"), new Car("b"), new Car("c"));
	}

	@Test
	void move() {
		assertThat(participants.move(4, 10))
				.isEqualTo(participants.getParticipants());
	}

	@Test
	void getWinners() {
		participants.register(new String[] {"a","b","c"});
		assertThat(participants.getWinners()).contains("a", "b", "c");
	}

	@Test
	void getMax() {
		participants.register(new String[] {"a","b","c"});
		assertThat(participants.getMax()).isEqualTo(0);
	}
}