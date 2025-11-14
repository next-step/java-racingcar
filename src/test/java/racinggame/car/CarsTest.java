package racinggame.car;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_갯수만큼_자동차객체를_생성할_수_있다() {
        List<String> carNames = of("first", "second", "third");
        Cars cars = new Cars(carNames);

        assertThat(
                cars.size()
        ).isEqualTo(3);
    }
//
//    @Test
//    void 자동차들이_가진_포지션값중_가장_큰_값을_찾아낼_수_있다() {
//        Cars cars = new Cars("first", "second", "third");
//
//        assertThat(
//                cars.findMaxPositions()
//        ).isEqualTo(???);
//    }
//
//    @Test
//    void 포지션값중_가장_큰_값으로_우승차량을_찾아낼_수_있다() {
//        Cars cars = new Cars("first", "second", "third");
//        int maxPositions = 5;
//
//        assertThat(
//                cars.findWinners(maxPositions)
//        ).isEqualTo(???);
//    }


}