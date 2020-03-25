package racingGame.participant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.car.Car;
import racingGame.game.MovingRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class ParticipantsTest {

    private Car lyh;
    private Car khm;
    private Car khg;

    @BeforeEach
    void setUp() {
        lyh = new Car("lyh", 3);
        khm = new Car("khm", 3);
        khg = new Car("khg", 1);
    }

    @Test
    void verifyConstructByString() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Participants("");
                });
    }

    @Test
    void verifyConstructByList() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Participants(new ArrayList<>());
                });
    }

    @Test
    @DisplayName("우승자가 여러명일때 테스트 ")
    void getWinners() {
        Participants participants = new Participants(Arrays.asList(lyh, khm, khg));

        List<Car> winners = participants.getWinners();

        assertThat(winners).containsExactly(lyh, khm);
    }

    @Test
    @DisplayName("우승자 한명일때 테스트")
    void getWinner() {
        Car nayana = new Car("nayana", 10);
        Participants participants = new Participants(Arrays.asList(lyh, khm, khg, nayana));

        List<Car> winners = participants.getWinners();

        assertThat(winners).containsExactly(nayana);
    }


    @Test
    @DisplayName("Move 하는 Round 테스트")
    void startMoveRound() {
        Participants participants = new Participants(Arrays.asList(lyh, khm, khg));

        RoundScore roundScore = participants.startRound(new MovingRule() {
            @Override
            public boolean isMove() {
                return true;
            }
        });

        ParticipantScore lyhScore = new ParticipantScore(new Car("lyh", 4));
        ParticipantScore khmScore = new ParticipantScore(new Car("khm", 4));
        ParticipantScore khgScore = new ParticipantScore(new Car("khg", 2));
        assertThat(roundScore.getRecords()).containsExactly(lyhScore, khmScore, khgScore);
    }

    @Test
    @DisplayName("Move 하지 않는 Round 테스트")
    void startNotMoveRound() {
        Participants participants = new Participants(Arrays.asList(lyh, khm, khg));

        RoundScore roundScore = participants.startRound(new MovingRule() {
            @Override
            public boolean isMove() {
                return false;
            }
        });

        ParticipantScore lyhScore = new ParticipantScore(lyh);
        ParticipantScore khmScore = new ParticipantScore(khm);
        ParticipantScore khgScore = new ParticipantScore(khg);
        assertThat(roundScore.getRecords()).containsExactly(lyhScore, khmScore, khgScore);
    }
}