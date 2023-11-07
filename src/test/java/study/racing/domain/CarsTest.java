package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {

    @Test
    @DisplayName("이름의 리스트를 입력받으면 자동차들을 생성할 수 있다.")
    void generateCarsTest() {
        // given
        Names names = new Names(
                List.of(
                        new Name("car1"),
                        new Name("car2"),
                        new Name("car3")
                )
        );
        // when
        Cars cars = new Cars(names);

        // then
        assertAll(
                () -> assertThat(cars.getValue().get(0)).isEqualTo(new Car(new Name("car1"), new Position(0))),
                () -> assertThat(cars.getValue().get(1)).isEqualTo(new Car(new Name("car2"), new Position(0))),
                () -> assertThat(cars.getValue().get(2)).isEqualTo(new Car(new Name("car3"), new Position(0)))
        );
    }

//    @Test
//    @DisplayName("자동차들에게 움직이지 않도록 할 수 있다..")
//    void doNotMoveCarsTest() {
//        // given
//        Cars cars = new Cars(new CarsNumber("2"));
//        DoNotMoveGenerator doNotMoveGenerator = new DoNotMoveGenerator();
//
//        // when
//        cars.move(doNotMoveGenerator, new TryCounts("1"));
//
//        // then
//        assertThat(cars).isEqualTo(new Cars(new CarsNumber("2")));
//    }

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
