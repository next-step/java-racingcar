package racingGame.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    @DisplayName("우승자 테스트")
    void getWinners() {
        Car lyh = new Car("yohan", 3);
        Car khm = new Car("khm", 3);
        Car khg = new Car("khg", 1);
        Participants participants = new Participants(Arrays.asList(lyh, khm, khg));

        List<Car> winners = participants.getWinners();

        assertThat(winners).containsExactly(lyh, khm);
    }
}