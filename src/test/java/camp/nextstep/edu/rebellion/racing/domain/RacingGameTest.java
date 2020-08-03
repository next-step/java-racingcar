package camp.nextstep.edu.rebellion.racing.domain;

import camp.nextstep.edu.rebellion.racing.stub.RacingGameStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    @DisplayName("자동차 경주 게임이 잘 수행 되는지 확인")
    @Test
    public void startTest() {
        // given
        int rounds = 5;
        List<String> cars = Arrays.asList("A,B,C");
        RacingGameStub racingGameStub = new RacingGameStub(cars, rounds);

        // when
        Record record = racingGameStub.start();
        List<SnapShotEntry> snapShotEntries = record.getSnapShots();
        SnapShotEntry round1 = snapShotEntries.get(0);
        SnapShotEntry round2 = snapShotEntries.get(1);
        SnapShotEntry round3 = snapShotEntries.get(2);
        SnapShotEntry round4 = snapShotEntries.get(3);
        SnapShotEntry finalRound = record.getFinalRoundSnapShot();

        // then
        assertAll(
                () -> assertThat(record.getSnapShots()).hasSize(rounds),
                () -> assertThat(getTotalDistances(round1)).isEqualTo(3),
                () -> assertThat(getTotalDistances(round2)).isEqualTo(6),
                () -> assertThat(getTotalDistances(round3)).isEqualTo(9),
                () -> assertThat(getTotalDistances(round4)).isEqualTo(12),
                () -> assertThat(getTotalDistances(finalRound)).isEqualTo(15),
                () -> assertThat(record.getFinalRoundSnapShot().getWinners())
                        .containsExactly("A", "B", "C")
        );
    }

    private int getTotalDistances(SnapShotEntry snapShotEntry) {
        return snapShotEntry.getCars().stream()
                .mapToInt(car -> car.getPosition())
                .sum();
    }
}
