package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.fake.FailRandomGenratorStub;
import study.racingcar.fake.SuccessRandomGenratorStub;

class ScoreTest {

    private Car carAlwaysReturnAboveFour;
    private Car carAlwaysReturnBelowFour;

    @BeforeEach
    void init(){
        carAlwaysReturnAboveFour = new Car(new SuccessRandomGenratorStub(new Random()));
        carAlwaysReturnBelowFour = new Car(new FailRandomGenratorStub(new Random()));
    }

    @DisplayName("차의 움짐임에 따라 점수를 char로 반환 - 차가 움직였을 때")
    @Test
    void a(){
        Score score = new Score(carAlwaysReturnAboveFour);
        assertThat(score.score()).isEqualTo(Score.MOVE_SCORE);
    }

    @DisplayName("차의 움짐임에 따라 점수를 char로 반환 - 차가 움직이지 않았을 때")
    @Test
    void b(){
        Score score = new Score(carAlwaysReturnBelowFour);
        assertThat(score.score()).isEqualTo(Score.STOP_SCORE);
    }
}