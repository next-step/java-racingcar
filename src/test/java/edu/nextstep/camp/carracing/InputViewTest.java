package edu.nextstep.camp.carracing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static edu.nextstep.camp.carracing.InputView.getTryCount;
import static edu.nextstep.camp.carracing.InputView.inputCarNames;
import static edu.nextstep.camp.carracing.StringUtils.split;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void 자동차_입력_테스트() {
        String carCount = "car1,car2,car3";
        assertThat(split(inputCarNames(new Scanner(new ByteArrayInputStream(carCount.getBytes())))).length).isEqualTo(3);
    }

    @Test
    void 시도_횟수_입력_테스트() {
        String tryCount = "3";
        assertThat(getTryCount(new Scanner(new ByteArrayInputStream(tryCount.getBytes())))).isEqualTo(3);
    }
}