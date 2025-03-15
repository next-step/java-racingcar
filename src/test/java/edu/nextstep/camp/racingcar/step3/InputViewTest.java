package edu.nextstep.camp.racingcar.step3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static edu.nextstep.camp.racingcar.step3.InputView.getCarCount;
import static edu.nextstep.camp.racingcar.step3.InputView.getTryCount;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

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
}