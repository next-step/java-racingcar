package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racing.strategy.DefaultMoveStategy;

import java.util.stream.Stream;

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


    RacingCar RacingCar = new RacingCar(new DefaultMoveStategy());

    @DisplayName("자동차 N번 움직이기(결과 배열 비교)")
    @ParameterizedTest
    @MethodSource("getRacingResultParamter")
    public void 자동차_N번_움직이기(int n, Integer[] expected) {
        assertThat(RacingCar.move(n)).isEqualTo(expected);
    }

    static Stream<Arguments> getRacingResultParamter() {
        return Stream.of(
                Arguments.of(3, new Integer[]{1, 1, 1}),
                Arguments.of(4, new Integer[]{1, 1, 1, 1}),
                Arguments.of(1, new Integer[]{1})
        );
    }



}
