package study.step4;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameInfoTest {

	private ArrayList<Car> participants;

	@BeforeEach
	void setUp() {
		participants = new ArrayList<>();

		Car car1 = new Car();
		car1.initPosition();
		car1.move();
		participants.add(car1);

		Car car2 = new Car();
		car2.initPosition();
		participants.add(car2);
	}

	@DisplayName("우승자의 위치와 maxPostion의 값은 같다.")
	@Test
	void Given_findWinners_Then_ReturnWinners() {
		RacingGameInfo racingGameInfo = new RacingGameInfo();
		racingGameInfo.setMaxPosition(1);
		racingGameInfo.setParticipants(participants);

		List<Car> winners = racingGameInfo.findWinners();

		assertThat(winners.get(0).getPosition()).isEqualTo(racingGameInfo.getMaxPosition());
	}
}