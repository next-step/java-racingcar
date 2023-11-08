package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.fake.FailRandomGenratorStub;
import study.racingcar.fake.SuccessRandomGenratorStub;

class ScoreTest {

    private Car car = new Car();
    private RandomGenerator successRandomGenratorStub = new SuccessRandomGenratorStub(new Random());

    private RandomGenerator failRandomGenratorStub = new FailRandomGenratorStub(new Random());

    @DisplayName("차의 움짐임에 따라 점수를 char로 반환 - 차가 움직였을 때")
    @Test
    void whenCarMoveMustReturnCharacter(){
        Score score = new Score(car, successRandomGenratorStub);
        assertThat(score.score()).isEqualTo(Score.MOVE_SCORE);
    }

    @DisplayName("차의 움짐임에 따라 점수를 char로 반환 - 차가 움직이지 않았을 때")
    @Test
    void whenCarStopMustReturnCharacter(){
        Score score = new Score(car, failRandomGenratorStub);
        assertThat(score.score()).isEqualTo(Score.STOP_SCORE);
    }
}