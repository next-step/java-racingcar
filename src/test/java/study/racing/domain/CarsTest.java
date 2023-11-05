package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차들에게 움직이지 않도록 할 수 있다..")
    void doNotMoveCarsTest() {
        // given
        Cars cars = new Cars(new CarsNumber("2"));
        DoNotMoveGenerator doNotMoveGenerator = new DoNotMoveGenerator();

        // when
        cars.move(doNotMoveGenerator, new TryCounts("1"));

        // then
        assertThat(cars).isEqualTo(new Cars(new CarsNumber("2")));
    }

    static class DoNotMoveGenerator implements NumberGenerator {

        @Override
        public int random(int range) {
            return 3;
        }
    }

    static class MoveGenerator implements NumberGenerator {

        @Override
        public int random(int range) {
            return 4;
        }
    }
}
