package study.step4.try3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesTest {

    @Test
    void 입력받은_자동차명이_유효한_값인지_확인하기() {
        assertThatThrownBy(()->CarName.of("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_자동차명을_콤마를_기준으로_자른_값을_가져오기() {
        assertThat(CarName.of("pobi,javaj,igi").getCarName().length()).isEqualTo(3);
    }
}
