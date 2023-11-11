package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.fake.FailRandomGenratorStub;
import study.racingcar.fake.ScoreBoardStub;
import study.racingcar.fake.SuccessRandomGenratorStub;

public class RoundTest {

    private final Car car = new Car("name");
    private Cars cars;
    private final RandomGenerator successRandomGenratorStub = new SuccessRandomGenratorStub(new Random());
    private final RandomGenerator failRandomGenratorStub = new FailRandomGenratorStub(new Random());

    @BeforeEach
    void init(){
        cars = Cars.from(List.of(this.car));
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
        Round round = new Round(cars);
        ScoreBoardStub scoreBoard = new ScoreBoardStub();
        ScoreEachRound eachRound = round.race(scoreBoard, successRandomGenratorStub);

        assertThat(eachRound).isEqualTo(new ScoreEachRound(List.of(new Score(car, successRandomGenratorStub))));
    }

    @DisplayName("라운드 race() - 차가 멈춤")
    @Test
    void roundRacingWhenCarStop(){
        Round round = new Round(cars);
        ScoreBoardStub scoreBoard = new ScoreBoardStub();
        ScoreEachRound eachRound = round.race(scoreBoard, failRandomGenratorStub);

        assertThat(eachRound).isEqualTo(new ScoreEachRound(List.of(new Score(car, failRandomGenratorStub))));
    }

    Round emptyRound(){
        List<Car> carList = List.of(new Car("name"));
        return new Round(new Cars(carList));
    }

}
