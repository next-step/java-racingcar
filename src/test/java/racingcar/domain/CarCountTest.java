package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarCountTest {
    @Test
    @DisplayName("자동차 개수는 한대 이상이다.")
    void create_with_count_over_minimum() {
        new CarCount(1);
    }

    @Test
    @DisplayName("자동차 개수가 1개보다 작으면 에러가 발생한다.")
    void create_with_count_under_minimum() {
        assertThatThrownBy(() -> new CarCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 한대 이상이 필요합니다.");
    }

    @Test
    @DisplayName("자동차 대수 만큼 자동차를 생성한다.")
    void create_cars_with_count() {
        assertThat(new CarCount(2).create().size()).isEqualTo(2);
    }
}
