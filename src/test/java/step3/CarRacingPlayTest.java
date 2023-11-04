package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarRacingPlayTest {

    private CarRacingPlay carRacingPlay;
    private final RandomValueGenerator randomValueGenerator = mock(RandomValueGenerator.class);

    @BeforeEach
    void setUp() {
        carRacingPlay = new CarRacingPlay(randomValueGenerator);
    }


    @ParameterizedTest(name = "0 ~ 9 사이의 값을 반환합니다.")
    @ValueSource(doubles = {0, 0.41, 0.999})
    void getRandomValue(double randomValue) {
        // given
        // when
        int result = carRacingPlay.getRacingConditionValue(randomValue);
        // then
        assertThat(result).isBetween(0, 9);
    }

    @Test
    @DisplayName("random 값이 4 이상이면 true 를 반환합니다.")
    void trueCondition() {
        // given
        int randomValue = 4;
        // when
        boolean result = carRacingPlay.checkRacingCondition(randomValue);
        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("random 값이 4 미만이면 false 를 반환합니다.")
    void falseCondition() {
        // given
        int randomValue = 3;
        // when
        boolean result = carRacingPlay.checkRacingCondition(randomValue);
        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("차 번호를 입력받아 경주 한 사이클을 진행하여 조건에 맞다면 Map의 차 번호를 key로 갖는 value를 1 증가 시킵니다.")
    void goCar() {
        // given
        int carNumber = 1;
        doReturn(0.4).when(randomValueGenerator).generateRandomValue();

        Map<Integer, Integer> racingBoard = new HashMap<>();
        racingBoard.put(carNumber, 0);
        // when
        carRacingPlay.race(carNumber, racingBoard);
        // then
        assertThat(racingBoard.get(carNumber)).isEqualTo(1);
    }

    @Test
    @DisplayName("차 번호를 입력받아 경주 조건에 맞지 않다면 Map 의 value 값을 증가시키지 않습니다.")
    void doNotGoCar() {
        // given
        int carNumber = 1;
        doReturn(0.39).when(randomValueGenerator).generateRandomValue();

        Map<Integer, Integer> racingBoard = new HashMap<>();
        racingBoard.put(carNumber, 0);
        // when
        carRacingPlay.race(carNumber, racingBoard);
        // then
        assertThat(racingBoard.get(carNumber)).isEqualTo(0);
    }
}