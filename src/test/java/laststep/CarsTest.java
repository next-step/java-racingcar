package laststep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laststep.domain.Car;
import laststep.domain.Cars;
import laststep.service.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 수 1미만일 때 예외")
    void validateCarsSize() {
        assertThatThrownBy(() -> new Cars(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 리스트는 한 대 이상이어야 해요");
    }

    @Test
    @DisplayName("자동차들 생성 확인")
    void cars() {
        Car pobi = new Car("pobi");
        Car wuga = new Car("wuga");
        Car nara = new Car("nara");
        Cars actual = new Cars(List.of(pobi, wuga, nara));

        assertThat(actual).isEqualTo(new Cars(List.of(pobi, wuga, nara)));
    }

    @Test
    @DisplayName("우승자 확인")
    void findWinner() {
        MoveStrategy strategy = () -> true;

        Car pobi = new Car("pobi");
        Car wuga = new Car("wuga");
        Car nara = new Car("nara");

        wuga.move(strategy);
        nara.move(strategy);

        Cars actual = new Cars(List.of(pobi, wuga, nara));
        Cars winners = actual.findWinners();

        Cars expected = new Cars(List.of(wuga, nara));

        assertThat(winners).isEqualTo(expected);
    }
}
