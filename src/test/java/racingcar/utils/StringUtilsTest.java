package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void 자동차_이름_분리_생성_테스트() {
        String[] splitCarNames = StringUtils.splitCarNames("pobi,woni,jun");
        assertThat(splitCarNames).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    @Test
    void 자동차_이름_분리_예외_테스트() {
        String[] splitCarNames = StringUtils.splitCarNames("pobi,woni/jun");
        assertThat(splitCarNames.length).isEqualTo(2);
    }

}