package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        this.cars = new Cars(List.of(
                new Car("pang", 5),
                new Car("nem", 5),
                new Car("pobi", 3),
                new Car("crong", 2),
                new Car("honux", 1)
        ));
    }

    @Nested
    class getStatus_메서드는 {

        @Test
        void 모든_자동차_이름과_목록을_리턴한다() {
            List<String> carsStatus = cars.getStatus();
            assertThat(carsStatus).containsExactly(
                    "pang : -----",
                    "nem : -----",
                    "pobi : ---",
                    "crong : --",
                    "honux : -"
            );
        }
    }

    @Nested
    class findWinners_메서드는 {

        @Test
        void 포지션이_제일_긴_자동차들을_리턴한다() {
            Cars winners = cars.findWinners();

            assertThat(winners).isEqualTo(
                    new Cars(List.of(
                            new Car("pang", 5),
                            new Car("nem", 5)
                    ))
            );
        }
    }

    @Nested
    class toString_메서드는 {

        @Test
        void name() {
            assertThat(cars.toString()).isEqualTo(
                    "pang, nem, pobi, crong, honux"
            );
        }
    }
}
