package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("우승자 인원 확인")
    @Test
    void 우승자_인원() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("유재석"), new Position(5)));
        cars.add(new Car(new Name("강호동"), new Position(5)));
        cars.add(new Car(new Name("박성광"), new Position(3)));
        Cars carSample = new Cars(cars);

        assertThat(carSample.getWinner().size()).isEqualTo(2);
    }

    @DisplayName("차량 결과 조회")
    @Test
    void 차량_결과() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("유재석"), new Position(5)));
        cars.add(new Car(new Name("강호동"), new Position(3)));
        Cars carSample = new Cars(cars);

        assertThat(carSample.getResult()).isEqualTo(cars);
    }
}
