package racingGame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.car.Car;
import racingGame.participant.Participants;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private Car lyh;
    private Car khm;
    private Car khg;
    private Participants participants;

    @BeforeEach
    void setUp() {
        lyh = new Car("lyh", 5);
        khm = new Car("khm", 3);
        khg = new Car("khg", 4);
        participants = new Participants(Arrays.asList(lyh, khm, khg));
    }

    @Test
    @DisplayName("RacingGame start()를 통한 우승자 테스트")
    void start() {
        RacingGame racingGame = new RacingGame(participants, 5);

        GameResult result = racingGame.start(new MovingRule() {
            @Override
            public boolean isMove() {
                return true;
            }
        });

        assertThat(result.getWinners()).containsExactly(lyh);
    }
}