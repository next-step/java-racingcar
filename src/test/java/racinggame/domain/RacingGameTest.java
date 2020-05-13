package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.dto.RacingGameInfo;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    @DisplayName("레이싱게임을 수행하면 모든 경기의 게임결과 스냅샷리스트를 반환한다")
    @Test
    void racingGame() {
        //given
        int numberOfCar = 5;
        int numberOfAttempt = 3;
        RacingGameInfo racingGameInfo = new RacingGameInfo(String.valueOf(numberOfCar), String.valueOf(numberOfAttempt));
        RacingGame racingGame = new RacingGame(racingGameInfo);
        Engine engine = () -> true;

        //when
        List<RacingGameSnapshot> snapshots = racingGame.raceWith(engine);

        //then
        assertAll(
                () -> assertThat(snapshots.size()).isEqualTo(numberOfAttempt),
                () -> assertThat(snapshots.get(0).getCarSnapShots().size()).isEqualTo(numberOfCar),
                () -> assertThat(snapshots.get(0).getCarSnapShots().get(0).getLocation()).isEqualTo(1),
                () -> assertThat(snapshots.get(1).getCarSnapShots().get(0).getLocation()).isEqualTo(2),
                () -> assertThat(snapshots.get(2).getCarSnapShots().get(0).getLocation()).isEqualTo(3)
        );
    }

}
