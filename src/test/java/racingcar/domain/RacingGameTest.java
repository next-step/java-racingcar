package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("몇 대의 자동차로 몇 번의 이동을 할 것인지 입력할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"3 : 1", "3 : 3", "5 : 1", "5 : 3", "5 : 5", "5 : 10"}, delimiter = ':')
    public void init(int totalCarCount, int time) throws NoSuchFieldException, IllegalAccessException {
        RacingGame racingCarGame = new RacingGame(time, totalCarCount); // time: 몇 번, totalCarCount: 몇 대

        Field filedTime = RacingGame.class.getDeclaredField("time");
        Field fieldCarPosition = RacingGame.class.getDeclaredField("carPosition");

        filedTime.setAccessible(true);
        fieldCarPosition.setAccessible(true);

        int existingTime = (int) filedTime.get(racingCarGame);
        int[] existingCarPosition = (int[]) fieldCarPosition.get(racingCarGame);

        assertThat(existingTime).isEqualTo(time);
        assertThat(existingCarPosition).hasSize(totalCarCount);
    }

    @DisplayName("자동차는 조건이 4 이상일 때만 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 : false", "2 : false", "3 : false", "4 : true"}, delimiter = ':')
    void RacingCarForwardOnConditionGraterThanOrEqualForTest(int condition, boolean expected) {

        RacingGame racingGame = new RacingGame(1,1);
        boolean forwardCondition = racingGame.isForward(condition);

        assertThat(forwardCondition).isEqualTo(expected);
    }
}
