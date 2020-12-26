package step5.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    @DisplayName("자동차 대수 만큼 전진 로직 루프 테스트 코드")
    void moveCars() {
        racing = new Racing("jthis,zino,vj",1);
        for(Car car : racing.getCarList())
            assertThat(car.carPosition()).isIn(0,1);
    }

    @Test
    @DisplayName("전진 횟수 만큼 전진 로직 루프 테스트 코드")
    void numberOfCarMove() {
        racing = new Racing() {
            @Override
            protected void race() {
                racing.getCarList().forEach(car -> car.move(() -> true));
            }
        };

        assertThat(racing.getCarList().get(0).carPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자 체크")
    void winner() {
        Cars cars = new Cars(Arrays.asList(
                new Car(3, "a"),
                new Car(4, "b"),
                new Car(5, "c")));

        assertThat(cars.getWinnerNames()).isEqualTo("c");
    }

    @Test
    @DisplayName("중복 우승자 체크")
    void overlapWinner() {
        Cars cars = new Cars(Arrays.asList(
                new Car(3, "a"),
                new Car(3, "b"),
                new Car(3, "c")));

        assertThat(cars.getWinnerNames()).isEqualTo("a, b, c");
    }
}
