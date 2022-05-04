package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class WinnerTest {

    @Test
    @DisplayName("우승한 자동차들의 이동 거리가 다르면 안된다.")
    void winnerPositionTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("a", 5));
        carList.add(new Car("a", 4));

        assertThatIllegalStateException().isThrownBy(() -> new Winners(carList));
    }
}
