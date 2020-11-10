package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("test");
    }

    @Test
    @DisplayName("자동차 무조건 전진 시키고 이동거리체크")
    void 자동차_전진_테스트() {
        // given
        RaceRule raceRule = () -> true;

        // when
        car.move(raceRule);

        // then
        assertThat(car.getDistance()).isNotZero();
    }

    @Test
    @DisplayName("자동차 이름 5글자 초과 작성시 IllegalArgumentException 발생")
    void 자동차_이름_5글자_초과작성_테스트() {
        assertThatThrownBy(() ->
                new Car("testcar")
        ).isInstanceOf(IllegalArgumentException.class);

    }
}
