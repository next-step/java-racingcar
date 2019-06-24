package edu.nextstep.racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-23 23:48
 */
public class CarNamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"TEST1", "TEST2"})
    void 자동차들의_이름_가져오기(String carNames) {
        List<String> carNameList = new ArrayList<>();
        carNameList.add("TEST1");
        carNameList.add("TEST2");

        CarNames names = CarNames.of(carNameList);
        assertThat(names.getNames().contains(carNames)).isTrue();
    }
}
