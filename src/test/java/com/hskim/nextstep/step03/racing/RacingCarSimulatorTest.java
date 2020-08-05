package com.hskim.nextstep.step03.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/*
    com.hskim.nextstep.step03 - RacingCarSimulator class 테스트
 */
public class RacingCarSimulatorTest {

    private RacingCarSimulator racingCarSimulator;

    @BeforeEach
    void setUp() {

        racingCarSimulator = new RacingCarSimulator();
    }

    /*
        setRacingCarList로 만들어진 racingCarList의 크기가 getRacingCarList로 가져온 크기와 같은지 검증
     */
    @DisplayName("setRacingCarList() & getRacingCarList() 메소드 검증")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void racingCarListGetterSetterTest(int carNum) {

        racingCarSimulator.setRacingCarList(carNum);
        assertThat(racingCarSimulator.getRacingCarList().size()).isEqualTo(carNum);
    }

}
