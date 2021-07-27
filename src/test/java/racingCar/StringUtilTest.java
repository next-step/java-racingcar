package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.utils.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    void 자동차이름_입력받기() {
        assertThat(StringUtil.divideByComma("pobi,crong,honux"))
                .isEqualTo(new String[]{"pobi", "crong", "honux"});
    }

}
