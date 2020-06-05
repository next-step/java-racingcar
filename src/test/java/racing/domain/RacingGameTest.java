package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private final String cars = "hello,world,test";
    private final int numberOfRound = 10;

    @Test
    @DisplayName("레이스 라운드의 갯수가 입력 받은 라운드의 갯수와 일치 하는 지 테스트")
    void isRacingResultSizeEqualWithNumberOfRound() {
        RacingGame racingGame = new RacingGame(cars, numberOfRound);
        RacingResult racingResult = racingGame.play(new ForceMoveStrategy());

        assertThat(racingResult.getRacingRoundSize()).isEqualTo(numberOfRound);
    }

    @Test
    @DisplayName("레이스 자동차의 갯수가 입력 받은 자동차의 갯수와 일치 하는 지 테스트")
    void isRacingResultEqualWithNumberOfCar() {
        RacingGame racingGame = new RacingGame(cars, numberOfRound);
        RacingResult racingResult = racingGame.play(new ForceMoveStrategy());

        for (int i = 1; i <= numberOfRound; i++) {
            int numberOfRaceCar = racingResult.getRoundResult(i).size();
            assertThat(numberOfRaceCar).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("레이싱의 결과가 항상 자동차를 움직였을 경우의 결과와 일치하는 지 테스트")
    void isRacingMovementResultEqualWithForceStrategy() {
        RacingGame racingGame = new RacingGame(cars, numberOfRound);
        RacingResult racingResult = racingGame.play(new ForceMoveStrategy());

        for (int i = 1; i <= numberOfRound; i++) {
            int shouldLocation = i;
            List<Car> roundResult = racingResult.getRoundResult(i);
            roundResult.forEach((car -> assertThat(car.getLocation()).isEqualTo(shouldLocation)));
        }
    }

    @Test
    @DisplayName("레이싱의 결과가 자동차가 움직이지 않았을 경우 결과 일치하는 지 테스트")
    void isRacingMovementResultEqualWithSuspendStrategy() {
        RacingGame racingGame = new RacingGame(cars, numberOfRound);
        RacingResult racingResult = racingGame.play(new SuspendMoveStrategy());

        for (int i = 1; i <= numberOfRound; i++) {
            List<Car> roundResult = racingResult.getRoundResult(i);
            roundResult.forEach((car -> assertThat(car.getLocation()).isEqualTo(0)));
        }
    }
}
