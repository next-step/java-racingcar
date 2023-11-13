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
        Names names = new Names(List.of("car1", "car2", "car3"));
        List<Name> value1 = names.getValue();

        Name name = value1.get(0);
        Name name1 = new Name("car1");

        // when
        Cars cars = new Cars(names);

        // then
        assertAll(
                () -> assertThat(cars.getValue().get(0))
                        .isEqualTo(new Car(new Name("car1"), new Position(1))),

                () -> assertThat(cars.getValue().get(1))
                        .isEqualTo(new Car(new Name("car2"), new Position(1))),

                () -> assertThat(cars.getValue().get(2))
                        .isEqualTo(new Car(new Name("car3"), new Position(1)))
        );
    }

    @Test
    @DisplayName("우승자를 가려낼 수 있다.")
    void findWinnersTest() {
        // given
        Cars cars = new Cars(new Names(List.of("car1", "car2", "car3")));

        // when
        String winners = cars.findWinners();

        // then
        assertThat(winners).isEqualTo("car1, car2, car3");
    }
}
