package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @Test
    @DisplayName("RacingCars 객체를 만든다.")
    void create_racing_cars() {
        RacingCars rc = RacingCars.create("a,b,c");
        assertThat(rc.getValue().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("RacingCars 객체를 만들 때 5자 이상의 이름을 입력하면 예외가 발생한다.")
    void create_racing_cars_negative() throws Exception {
        assertThatThrownBy(() -> RacingCars.create("qwertyasdfg"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("RacingCars 객체를 만들 때 이름을 입력하지 않으면 예외가 발생한다.")
    void create_racing_cars_negative_blank() throws Exception {
        assertThatThrownBy(() -> RacingCars.create(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("구분자는 ,를 사용해서 이름을 1개 이상 입력해주세요");
    }
    }
}
