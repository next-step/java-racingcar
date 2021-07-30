package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private final int NUMBER_OF_TURNS = 10;
    private final List<String> carNames = Stream.of("pobi", "crong", "honux").collect(Collectors.toList());

    private RacingGame racingGame;

    @BeforeEach
    void init() {
        this.racingGame = new RacingGame(new RacingGameConfiguration(carNames, NUMBER_OF_TURNS));
    }

    @Test
    @DisplayName("생성자 테스트")
    void gameTest() {
        assertThat(racingGame.getRacingEntry().getCars().size()).isEqualTo(3);

        racingGame.getRacingEntry().getCars().forEach(e -> assertThat(e).isExactlyInstanceOf(Car.class));
    }

    @Test
    @DisplayName("게임 진행 테스트")
    void startGameTest() {
        // 모든 차가 움직이지 않았는지 확인
        RacingGame stoppedRacingGame = new RacingGame(new RacingGameConfiguration(carNames, NUMBER_OF_TURNS));
        stoppedRacingGame.startGame(() -> false);

        stoppedRacingGame.getRacingEntry().getCars()
                .forEach(car -> assertThat(car.getCarLocation().equals(new CarLocation(0))).isTrue());

        assertThat(stoppedRacingGame.getCurrentTurn()).isEqualTo(NUMBER_OF_TURNS);

        // 모든 차가 NUMBER_OF_TURNS 만큼 움직였는지 확인
        RacingGame alwaysMovingRacingGame = new RacingGame(new RacingGameConfiguration(carNames, NUMBER_OF_TURNS));
        alwaysMovingRacingGame.startGame(() -> true);

        alwaysMovingRacingGame.getRacingEntry().getCars()
                .forEach(car -> assertThat(car.getCarLocation().equals(new CarLocation(NUMBER_OF_TURNS))).isTrue());

        assertThat(alwaysMovingRacingGame.getCurrentTurn()).isEqualTo(NUMBER_OF_TURNS);
    }

}
