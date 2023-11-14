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

        // when
        Cars cars = new Cars(names);

        // then
        assertAll(
                () -> assertThat(cars.getValue().contains(new Car(new Name("car1"), new Position(1)))).isTrue(),
                () -> assertThat(cars.getValue().contains(new Car(new Name("car2"), new Position(1)))).isTrue(),
                () -> assertThat(cars.getValue().contains(new Car(new Name("car3"), new Position(1)))).isTrue()
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
