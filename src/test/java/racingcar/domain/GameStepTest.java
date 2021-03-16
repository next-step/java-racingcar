package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStepTest {

    @Test
    void isRunning() {
        //given
        final int testNowStep = 3;
        final int testStepNumber = 5;

        //when
        GameStep resultGameStep = new GameStep(testNowStep, testStepNumber);

        //then
        assertThat(resultGameStep.isRunning()).isTrue();
    }

    @Test
    void increaseStep() {
        //given
        final int STEP_INCREASE = 1;
        final int testNowStep = 3;
        final int testStepNumber = 5;
        GameStep resultGameStep = new GameStep(testNowStep, testStepNumber);
        GameStep expectGameStep = new GameStep(testNowStep + STEP_INCREASE, testStepNumber);
        //when
        resultGameStep.increaseStep();

        //then
        assertThat(resultGameStep).isEqualToComparingFieldByField(expectGameStep);
    }


}
