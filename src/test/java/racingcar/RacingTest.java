package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Garage;
import racingcar.model.Racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {

    @Test
    void 차_생성() {
        Racing racing = new Racing();

        Garage garage = racing.ready("a,b,c");

        assertThat(garage.getCars()).hasSize(3);
    }

    @Test
    void 차_생성후_차_이름_확인() {
        Racing racing = new Racing();

        Garage garage = racing.ready("a,b,c");

        assertThat(garage.getCars()).contains(new Car("a"));
    }

    @Test
    void 차_이름_중복_불가() {
        Racing racing = new Racing();

        assertThatThrownBy(() ->
                racing.ready("a,b,c,a")
        ).isInstanceOf(IllegalArgumentException.class);
    }


}