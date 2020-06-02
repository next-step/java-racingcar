package racing.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱의 결과가 라운드의 갯수와 일치 하는 지 테스트")
    void isRacingResultSizeEqualWithNumberOfRound() {
        int numberOfCar = 5;
        int numberOfRound = 10;

        RacingGame racingGame = new RacingGame(numberOfCar, numberOfRound);
        RacingResult racingResult = racingGame.play(new ForceMoveStrategy());

        assertThat(racingResult.getRacingRoundSize()).isEqualTo(numberOfRound);
    }

    @Test
    @DisplayName("레이싱의 경과가 자동차의 갯수와 일치 하는 지 테스트")
    void isRacingResultEqualWithNumberOfCar() {
        int numberOfCar = 5;
        int numberOfRound = 10;

        RacingGame racingGame = new RacingGame(numberOfCar, numberOfRound);
        RacingResult racingResult = racingGame.play(new ForceMoveStrategy());

        assertThat(racingResult.getRoundResult(0).size()).isEqualTo(numberOfCar);
        assertThat(racingResult.getRoundResult(5).size()).isEqualTo(numberOfCar);
        assertThat(racingResult.getRoundResult(9).size()).isEqualTo(numberOfCar);
    }

    @Test
    @DisplayName("레이싱의 결과가 예정된 움직임과 일치하는 지 테스트")
    void isRacingMovementResultEqualWithStrategy() {
        int numberOfCar = 5;
        int numberOfRound = 10;

        RacingGame racingGame = new RacingGame(numberOfCar, numberOfRound);
        RacingResult racingResult = racingGame.play(new ForceMoveStrategy());

        racingResult.getRoundResult(0).forEach(movement -> {
            assertThat(movement).isEqualTo(1);
        });

        racingResult.getRoundResult(9).forEach(movement -> {
            assertThat(movement).isEqualTo(10);
        });
    }
}
