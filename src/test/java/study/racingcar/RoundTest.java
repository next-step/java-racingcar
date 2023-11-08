package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.fake.FailRandomGenratorStub;
import study.racingcar.fake.ScoreBoardStub;
import study.racingcar.fake.SuccessRandomGenratorStub;

public class RoundTest {
    private Cars movingCars;
    private Cars stopedCars;
    private RandomGenerator successRandomGenratorStub = new SuccessRandomGenratorStub(new Random());
    private RandomGenerator failRandomGenratorStub = new FailRandomGenratorStub(new Random());

    @BeforeEach
    void init(){
        Car carAlwaysReturnAboveFour = new Car();
        Car carAlwaysReturnBelowFour = new Car();

        List<Car> movedCarList = new ArrayList<>(List.of(carAlwaysReturnAboveFour));
        movingCars = Cars.from(movedCarList);

        List<Car> stopedCarList = new ArrayList<>(List.of(carAlwaysReturnBelowFour));
        stopedCars = Cars.from(stopedCarList);
    }

    @DisplayName("라운드의 race()가 예외를 던지지 않음")
    @Test
    void roundRacingWithoutException(){
        Round round = emptyRound();
        ScoreBoard scoreBoard = new ScoreBoard();
        assertThatNoException().isThrownBy(() -> round.race(scoreBoard, successRandomGenratorStub));
    }

    @DisplayName("라운드 race() - 차가 움직임")
    @Test
    void roundRacingWhenCarMoving(){
        Round round = new Round(movingCars);
        ScoreBoardStub scoreBoard = new ScoreBoardStub();
        round.race(scoreBoard, successRandomGenratorStub);

        scoreBoard.scores().forEach(score -> {
            score.keySet().forEach(car -> {
                assertThat(car.canMove(successRandomGenratorStub)).isEqualTo(MoveStatus.MOVE);
            });
        });
    }

    @DisplayName("라운드 race() - 차가 멈춤")
    @Test
    void roundRacingWhenCarStop(){
        Round round = new Round(stopedCars);
        ScoreBoardStub scoreBoard = new ScoreBoardStub();
        round.race(scoreBoard, failRandomGenratorStub);

        scoreBoard.scores().forEach(score -> {
            score.keySet().forEach(car -> {
                assertThat(car.canMove(failRandomGenratorStub)).isEqualTo(MoveStatus.STOP);
            });
        });
    }

    Round emptyRound(){
        List<Car> carList = List.of(new Car());
        return new Round(new Cars(carList));
    }

}
