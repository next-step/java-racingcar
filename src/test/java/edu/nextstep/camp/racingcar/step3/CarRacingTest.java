package edu.nextstep.camp.racingcar.step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static edu.nextstep.camp.racingcar.step3.CarRacing.moveOrStay;
import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @ParameterizedTest
    @CsvSource(value = {"0,''", "1,''", "2,''", "3,''", "4,-", "5,-", "6,-", "7,-", "8,-", "9,-"})
    void 자동차_이동_테스트(int num, String expected) {
        assertThat(moveOrStay(num)).isEqualTo(expected);
    }
}
