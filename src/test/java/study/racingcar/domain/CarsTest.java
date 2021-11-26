package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private List<Car> carGroup;
    private Cars cars;
    private int maxPosition = 5;

    @BeforeEach
    void setUp() {
        carGroup = new ArrayList<>();
        carGroup.add(new Car(new Name("유재석"), new Position(maxPosition)));
        carGroup.add(new Car(new Name("강호동"), new Position(maxPosition)));
        carGroup.add(new Car(new Name("박성광"), new Position(maxPosition-2)));
        cars = new Cars(carGroup);
    }

    @DisplayName("라운드 이동 조회")
    @Test
    void 라운드_이동() {
        cars.endRound(() -> true);
        Car firstCar = cars.getResult()
                                    .stream()
                                    .findFirst()
                                    .get();
        assertThat(firstCar.getLocation()).isEqualTo(++maxPosition);
    }

    @DisplayName("차량 결과 조회")
    @Test
    void 차량_결과() {
        assertThat(cars.getResult()).isEqualTo(carGroup);
    }

    @DisplayName("우승자 인원 확인")
    @Test
    void 우승자_인원() {
        assertThat(cars.getWinner().size()).isEqualTo(2);
    }
}
