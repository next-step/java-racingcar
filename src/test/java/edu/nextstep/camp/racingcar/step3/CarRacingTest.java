package edu.nextstep.camp.racingcar.step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static edu.nextstep.camp.racingcar.step3.CarRacing.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {
    @Test
    void 자동차_입력_테스트() {
        String carCount = "5";
        assertThat(getCarCount(new Scanner(new ByteArrayInputStream(carCount.getBytes())))).isEqualTo(5);
    }

    @Test
    void 시도_횟수_입력_테스트() {
        String tryCount = "3";
        assertThat(getTryCount(new Scanner(new ByteArrayInputStream(tryCount.getBytes())))).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,''", "1,''", "2,''", "3,''", "4,-", "5,-", "6,-", "7,-", "8,-", "9,-"})
    void 자동차_이동_테스트(int num, String expected) {
        assertThat(moveOrStay(num)).isEqualTo(expected);
    }
}
