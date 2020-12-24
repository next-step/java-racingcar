package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        racing.setCars(Racing.registerCars("jthis,zino,vj"));
        racing.numberOfCarMove(1);
        for(Car car : racing.getCars())
            assertThat(car.carPosition()).isIn(0,1);
    }

    @Test
    @DisplayName("전진 횟수 만큼 전진 로직 루프 테스트 코드")
    void numberOfCarMove() {
        racing = new Racing() {
            @Override
            protected void race() {
                racing.getCars().forEach(car -> car.move(() -> true));
            }
        };
        racing.setCars(Racing.registerCars("jthis"));
        racing.numberOfCarMove(5);
        assertThat(racing.getCars().get(0).carPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자 체크")
    void winner() {
        Cars cars = new Cars(Arrays.asList(
                new Car(3, "a"),
                new Car(4, "b"),
                new Car(5, "c")));

        racing.setCars(cars);
        assertThat(racing.getWinners()).isEqualTo("c");
    }

    @Test
    @DisplayName("중복 우승자 체크")
    void overlapWinner() {
        Cars cars = new Cars(Arrays.asList(
                new Car(3, "a"),
                new Car(3, "b"),
                new Car(3, "c")));

        racing.setCars(cars);
        assertThat(racing.getWinners()).isEqualTo("a, b, c");
    }
}
