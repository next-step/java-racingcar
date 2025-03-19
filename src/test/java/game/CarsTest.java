package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;

class CarsTest {

    @DisplayName("전진하는 전략일 때는 1칸 전진한다")
    @Test
    void race_1() {
        // given
        Cars cars = new Cars(new CarNames(List.of(new CarName("a"), new CarName("b"), new CarName("c"))));
        // when
        cars.race(() -> 4);
        // then
        Assertions.assertThat(cars.positionByName())
                .containsExactly(new AbstractMap.SimpleEntry<>("a", 1), new AbstractMap.SimpleEntry<>("b", 1), new AbstractMap.SimpleEntry<>("c", 1));
    }

    @DisplayName("정지하는 전략일 때는 전진하지 않는다")
    @Test
    void race_2() {
        // given
        Cars cars = new Cars(new CarNames(List.of(new CarName("a"), new CarName("b"), new CarName("c"))));
        // when
        cars.race(() -> 3);
        // then
        Assertions.assertThat(cars.positionByName())
                .containsExactly(new AbstractMap.SimpleEntry<>("a", 0), new AbstractMap.SimpleEntry<>("b", 0), new AbstractMap.SimpleEntry<>("c", 0));
    }

    @Test
    @DisplayName("가장 멀리간 자동차가 우승한다.")
    void winners() {
        // 우승자 찾기
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));
        car1.move(4);
        car1.move(4);
        car1.move(4);
        car2.move(4);
        car2.move(4);
        car2.move(3);
        car3.move(4);
        car3.move(3);
        car3.move(3);
        Cars cars = new Cars(List.of(car1, car2, car3));
        // when
        List<String> winners = cars.winners();
        // then
        Assertions.assertThat(winners).containsExactly("car1");
    }

    @Test
    @DisplayName("가장 멀리간 자동차가 하나 이상인 경우 우승자는 한명 이상일 수 있다.")
    void winners_우승자여러명() {
        // 우승자 찾기
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));
        car1.move(4);
        car1.move(4);
        car1.move(4);
        car2.move(4);
        car2.move(4);
        car2.move(4);
        car3.move(4);
        car3.move(3);
        car3.move(3);
        Cars cars = new Cars(List.of(car1, car2, car3));
        // when
        List<String> winners = cars.winners();
        // then
        Assertions.assertThat(winners).containsExactly("car1", "car2");
    }
}
