package edu.nextstep.racing.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
 * create date  : 2019-06-22 16:00
 */
class SplitUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"kwon", "byeong", "yun"})
    void 콤마_기준으로_문자열자르기(String names) {
        List<String> carNames = SplitUtils.commaSplit("kwon,byeong,yun");
        assertThat(carNames.contains(names)).isTrue();
    }
}