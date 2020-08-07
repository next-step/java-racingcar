package racingcar;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    /**
     * 기능요구사항
     *
     * 1. 초간단 자동차 경주게임을 구현
     * 2. 주어진 획수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
     * 3. 사용자는 몇 대의 자동차로 몇번의 이동을 할 것인지 입력할 수 있어ㄷ야 한다.
     * 4. 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상일 경우이다.
     * 5. 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
     *
     * * 핵심 로직과 UI 담당하는 로직 구분
     */


    @ParameterizedTest
    @CsvSource(value={"3:3", "5:5"}, delimiter = ':')
    public void 레이싱_결과가져오기(int racingTurn, int expected) {
        assertThat(RacingCar.getRacingResult(racingTurn)).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value={"3:3", "5:5"}, delimiter = ':')
    public void 레이싱_결과(int racingCount, int expected) {
        assertThat(RacingCar.racing(racingCount)).hasSize(expected);
    }

    @Test
    public void 랜덤값가져오기_10보다_작은(){
        assertThat(RacingCar.getRandomValueUnder10()).isLessThan(10);
    }

    @ParameterizedTest
    @CsvSource(value={"3:false", "5:true"}, delimiter = ':')
    public void 최소값보다_큰지_판단(int randomValue, boolean expected){
        assertThat(RacingCar.isGreaterThan3(randomValue)).isEqualTo(expected);
    }

    @Test
    public void 얼마나갈지(){
        assertThat(RacingCar.run()).isStrictlyBetween(0, 9);
    }




}
