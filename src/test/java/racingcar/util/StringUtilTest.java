package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    @DisplayName("자동차 이름은 ,로 구분한다.")
    void split_car_names_by_comma() {
        assertThat(StringUtil.splitNames("a,b,c")).contains("a", "b", "c");
    }
}
